/* ====================================================================
   Licensed to the Apache Software Foundation (ASF) under one or more
   contributor license agreements.  See the NOTICE file distributed with
   this work for additional information regarding copyright ownership.
   The ASF licenses this file to You under the Apache License, Version 2.0
   (the "License"); you may not use this file except in compliance with
   the License.  You may obtain a copy of the License at

       http://www.apache.org/licenses/LICENSE-2.0

   Unless required by applicable law or agreed to in writing, software
   distributed under the License is distributed on an "AS IS" BASIS,
   WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
   See the License for the specific language governing permissions and
   limitations under the License.
==================================================================== */

package org.apache.poi.hslf.record;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.hslf.model.textproperties.*;
import org.apache.poi.hslf.model.textproperties.TextPropCollection.TextPropType;
import org.apache.poi.util.*;

/**
 * A StyleTextPropAtom (type 4001). Holds basic character properties
 *  (bold, italic, underline, font size etc) and paragraph properties
 *  (alignment, line spacing etc) for the block of text (TextBytesAtom
 *  or TextCharsAtom) that this record follows.
 * You will find two lists within this class.
 *  1 - Paragraph style list (paragraphStyles)
 *  2 - Character style list (charStyles)
 * Both are lists of TextPropCollections. These define how many characters
 *  the style applies to, and what style elements make up the style (another
 *  list, this time of TextProps). Each TextProp has a value, which somehow
 *  encapsulates a property of the style
 *
 * @author Nick Burch
 * @author Yegor Kozlov
 */

public final class StyleTextPropAtom extends RecordAtom
{
    private byte[] _header;
    private static final long _type = RecordTypes.StyleTextPropAtom.typeID;
    private byte[] reserved;

    private byte[] rawContents; // Holds the contents between write-outs

    /**
     * Only set to true once setParentTextSize(int) is called.
     * Until then, no stylings will have been decoded
     */
    private boolean initialised = false;

    /**
     * The list of all the different paragraph stylings we code for.
     * Each entry is a TextPropCollection, which tells you how many
     *  Characters the paragraph covers, and also contains the TextProps
     *  that actually define the styling of the paragraph.
     */
    private List<TextPropCollection> paragraphStyles;
    public List<TextPropCollection> getParagraphStyles() { return paragraphStyles; }
    /**
     * Updates the link list of TextPropCollections which make up the
     *  paragraph stylings
     */
    public void setParagraphStyles(List<TextPropCollection> ps) { paragraphStyles = ps; }
    /**
     * The list of all the different character stylings we code for.
     * Each entry is a TextPropCollection, which tells you how many
     *  Characters the character styling covers, and also contains the
     *  TextProps that actually define the styling of the characters.
     */
    private List<TextPropCollection> charStyles;
    public List<TextPropCollection> getCharacterStyles() { return charStyles; }
    /**
     * Updates the link list of TextPropCollections which make up the
     *  character stylings
     */
    public void setCharacterStyles(List<TextPropCollection> cs) { charStyles = cs; }

    /**
     * Returns how many characters the paragraph's
     *  TextPropCollections cover.
     * (May be one or two more than the underlying text does,
     *  due to having extra characters meaning something
     *  special to powerpoint)
     */
    public int getParagraphTextLengthCovered() {
        return getCharactersCovered(paragraphStyles);
    }
    /**
     * Returns how many characters the character's
     *  TextPropCollections cover.
     * (May be one or two more than the underlying text does,
     *  due to having extra characters meaning something
     *  special to powerpoint)
     */
    public int getCharacterTextLengthCovered() {
        return getCharactersCovered(charStyles);
    }
    private int getCharactersCovered(List<TextPropCollection> styles) {
        int length = 0;
        for(TextPropCollection tpc : styles) {
            length += tpc.getCharactersCovered();
        }
        return length;
    }

    /* *************** record code follows ********************** */

    /**
     * For the Text Style Properties (StyleTextProp) Atom
     */
    public StyleTextPropAtom(byte[] source, int start, int len) {
        // Sanity Checking - we're always at least 8+10 bytes long
        if(len < 18) {
            len = 18;
            if(source.length - start < 18) {
                throw new RuntimeException("Not enough data to form a StyleTextPropAtom (min size 18 bytes long) - found " + (source.length - start));
            }
        }

        // Get the header
        _header = new byte[8];
        System.arraycopy(source,start,_header,0,8);

        // Save the contents of the atom, until we're asked to go and
        //  decode them (via a call to setParentTextSize(int)
        rawContents = new byte[len-8];
        System.arraycopy(source,start+8,rawContents,0,rawContents.length);
        reserved = new byte[0];

        // Set empty lists, ready for when they call setParentTextSize
        paragraphStyles = new ArrayList<TextPropCollection>();
        charStyles = new ArrayList<TextPropCollection>();
    }


    /**
     * A new set of text style properties for some text without any.
     */
    public StyleTextPropAtom(int parentTextSize) {
        _header = new byte[8];
        rawContents = new byte[0];
        reserved = new byte[0];

        // Set our type
        LittleEndian.putInt(_header,2,(short)_type);
        // Our initial size is 10
        LittleEndian.putInt(_header,4,10);

        // Set empty paragraph and character styles
        paragraphStyles = new ArrayList<TextPropCollection>();
        charStyles = new ArrayList<TextPropCollection>();

        addParagraphTextPropCollection(parentTextSize);
        addCharacterTextPropCollection(parentTextSize);

        // Set us as now initialised
        initialised = true;

        try {
            updateRawContents();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


    /**
     * We are of type 4001
     */
    public long getRecordType() { return _type; }


    /**
     * Write the contents of the record back, so it can be written
     *  to disk
     */
    public void writeOut(OutputStream out) throws IOException {
        // First thing to do is update the raw bytes of the contents, based
        //  on the properties
        updateRawContents();

        // Write out the (new) header
        out.write(_header);

        // Write out the styles
        out.write(rawContents);

        // Write out any extra bits
        out.write(reserved);
    }


    /**
     * Tell us how much text the parent TextCharsAtom or TextBytesAtom
     *  contains, so we can go ahead and initialise ourselves.
     */
    public void setParentTextSize(int size) {
        if (initialised) return;
        
        int pos = 0;
        int textHandled = 0;

        paragraphStyles.clear();
        charStyles.clear();
        
        // While we have text in need of paragraph stylings, go ahead and
        // grok the contents as paragraph formatting data
        int prsize = size;
        while(pos < rawContents.length && textHandled < prsize) {
            // First up, fetch the number of characters this applies to
            int textLen = LittleEndian.getInt(rawContents,pos);
            textLen = checkTextLength(textLen, textHandled, size);
            textHandled += textLen;
            pos += 4;

            short indent = LittleEndian.getShort(rawContents,pos);
            pos += 2;

            // Grab the 4 byte value that tells us what properties follow
            int paraFlags = LittleEndian.getInt(rawContents,pos);
            pos += 4;

            // Now make sense of those properties
            TextPropCollection thisCollection = new TextPropCollection(textLen, TextPropType.paragraph);
            thisCollection.setIndentLevel(indent);
            int plSize = thisCollection.buildTextPropList(paraFlags, rawContents, pos);
            pos += plSize;

            // Save this properties set
            paragraphStyles.add(thisCollection);

            // Handle extra 1 paragraph styles at the end
            if(pos < rawContents.length && textHandled == size) {
                prsize++;
            }

        }
        if (rawContents.length > 0 && textHandled != (size+1)){
            logger.log(POILogger.WARN, "Problem reading paragraph style runs: textHandled = " + textHandled + ", text.size+1 = " + (size+1));
        }

        // Now do the character stylings
        textHandled = 0;
        int chsize = size;
        while(pos < rawContents.length && textHandled < chsize) {
            // First up, fetch the number of characters this applies to
            int textLen = LittleEndian.getInt(rawContents,pos);
            textLen = checkTextLength(textLen, textHandled, size);
            textHandled += textLen;
            pos += 4;

            // Grab the 4 byte value that tells us what properties follow
            int charFlags = LittleEndian.getInt(rawContents,pos);
            pos += 4;

            // Now make sense of those properties
            // (Assuming we actually have some)
            TextPropCollection thisCollection = new TextPropCollection(textLen, TextPropType.character);
            int chSize = thisCollection.buildTextPropList(charFlags, rawContents, pos);
            pos += chSize;

            // Save this properties set
            charStyles.add(thisCollection);

            // Handle extra 1 char styles at the end
            if(pos < rawContents.length && textHandled == size) {
                chsize++;
            }
        }
        if (rawContents.length > 0 && textHandled != (size+1)){
            logger.log(POILogger.WARN, "Problem reading character style runs: textHandled = " + textHandled + ", text.size+1 = " + (size+1));
        }

        // Handle anything left over
        if(pos < rawContents.length) {
            reserved = new byte[rawContents.length-pos];
            System.arraycopy(rawContents,pos,reserved,0,reserved.length);
        }

        initialised = true;
    }
    
    private int checkTextLength(int readLength, int handledSoFar, int overallSize) {
        if (readLength + handledSoFar > overallSize + 1) {
            logger.log(POILogger.WARN, "Style length of " + readLength + " at " + handledSoFar + 
                    " larger than stated size of " + overallSize + ", truncating");
            return overallSize + 1 - handledSoFar;
        }
        return readLength;
    }


    /**
     * Updates the cache of the raw contents. Serialised the styles out.
     */
    private void updateRawContents() throws IOException {
        if (initialised) {
            // Only update the style bytes, if the styles have been potentially
            // changed

            ByteArrayOutputStream baos = new ByteArrayOutputStream();
    
            // First up, we need to serialise the paragraph properties
            for(TextPropCollection tpc : paragraphStyles) {
                tpc.writeOut(baos);
            }
    
            // Now, we do the character ones
            for(TextPropCollection tpc : charStyles) {
                tpc.writeOut(baos);
            }
    
            rawContents = baos.toByteArray();
        }
        
        // Now ensure that the header size is correct
        int newSize = rawContents.length + reserved.length;
        LittleEndian.putInt(_header,4,newSize);
    }

    /**
     * Clear styles, so new collections can be added
     */
    public void clearStyles() {
        paragraphStyles.clear();
        charStyles.clear();
        reserved = new byte[0];
        initialised = true;
    }
    
    /**
     * Create a new Paragraph TextPropCollection, and add it to the list
     * @param charactersCovered The number of characters this TextPropCollection will cover
     * @return the new TextPropCollection, which will then be in the list
     */
    public TextPropCollection addParagraphTextPropCollection(int charactersCovered) {
        TextPropCollection tpc = new TextPropCollection(charactersCovered, TextPropType.paragraph);
        paragraphStyles.add(tpc);
        return tpc;
    }
    /**
     * Create a new Character TextPropCollection, and add it to the list
     * @param charactersCovered The number of characters this TextPropCollection will cover
     * @return the new TextPropCollection, which will then be in the list
     */
    public TextPropCollection addCharacterTextPropCollection(int charactersCovered) {
        TextPropCollection tpc = new TextPropCollection(charactersCovered, TextPropType.character);
        charStyles.add(tpc);
        return tpc;
    }

    /* ************************************************************************ */


    /**
     * Dump the record content into <code>StringBuffer</code>
     *
     * @return the string representation of the record data
     */
    public String toString(){
        StringBuffer out = new StringBuffer();

        out.append("StyleTextPropAtom:\n");
        if (!initialised) {
            out.append("Uninitialised, dumping Raw Style Data\n");
        } else {

            out.append("Paragraph properties\n");
            for(TextPropCollection pr : getParagraphStyles()) {
                out.append(pr);
            }

            out.append("Character properties\n");
            for(TextPropCollection pr : getCharacterStyles()) {
                out.append(pr);
            }
            
            out.append("Reserved bytes\n");
            out.append( HexDump.dump(reserved, 0, 0) );
        }

        out.append("  original byte stream \n");
        
        byte buf[] = new byte[rawContents.length+reserved.length];
        System.arraycopy(rawContents, 0, buf, 0, rawContents.length);
        System.arraycopy(reserved, 0, buf, rawContents.length, reserved.length);
        out.append( HexDump.dump(buf, 0, 0) );

        return out.toString();
    }
}
