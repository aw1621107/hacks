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
package org.apache.poi.xssf.usermodel;

import org.apache.poi.ss.usermodel.BorderFormatting;
import org.apache.poi.ss.usermodel.Color;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTBorder;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.STBorderStyle;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTBorderPr;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTColor;

/**
 * XSSF high level representation for Border Formatting component
 * of Conditional Formatting settings
 */
public class XSSFBorderFormatting implements BorderFormatting  {
    CTBorder _border;

    /*package*/ XSSFBorderFormatting(CTBorder border) {
        _border = border;
    }

    public short getBorderBottom() {
        STBorderStyle.Enum ptrn = _border.isSetBottom() ? _border.getBottom().getStyle() : null;
        return ptrn == null ? BORDER_NONE : (short)(ptrn.intValue() - 1);
    }

    public short getBorderDiagonal() {
        STBorderStyle.Enum ptrn = _border.isSetDiagonal() ? _border.getDiagonal().getStyle() : null;
        return ptrn == null ? BORDER_NONE : (short)(ptrn.intValue() - 1);
    }

    public short getBorderLeft() {
        STBorderStyle.Enum ptrn = _border.isSetLeft() ? _border.getLeft().getStyle() : null;
        return ptrn == null ? BORDER_NONE : (short)(ptrn.intValue() - 1);
    }

    public short getBorderRight() {
        STBorderStyle.Enum ptrn = _border.isSetRight() ? _border.getRight().getStyle() : null;
        return ptrn == null ? BORDER_NONE : (short)(ptrn.intValue() - 1);
    }

    public short getBorderTop() {
        STBorderStyle.Enum ptrn = _border.isSetTop() ? _border.getTop().getStyle() : null;
        return ptrn == null ? BORDER_NONE : (short)(ptrn.intValue() - 1);
    }

    public XSSFColor getBottomBorderColorColor() {
        if(!_border.isSetBottom()) return null;

        CTBorderPr pr = _border.getBottom();
        return new XSSFColor(pr.getColor());
    }
    public short getBottomBorderColor() {
        XSSFColor color = getBottomBorderColorColor();
        if (color == null) return 0;
        return color.getIndexed();
    }

    public XSSFColor getDiagonalBorderColorColor() {
        if(!_border.isSetDiagonal()) return null;

        CTBorderPr pr = _border.getDiagonal();
        return new XSSFColor(pr.getColor());
    }
    public short getDiagonalBorderColor() {
        XSSFColor color = getDiagonalBorderColorColor();
        if (color == null) return 0;
        return color.getIndexed();
    }

    public XSSFColor getLeftBorderColorColor() {
        if(!_border.isSetLeft()) return null;

        CTBorderPr pr = _border.getLeft();
        return new XSSFColor(pr.getColor());
    }
    public short getLeftBorderColor() {
        XSSFColor color = getLeftBorderColorColor();
        if (color == null) return 0;
        return color.getIndexed();
    }

    public XSSFColor getRightBorderColorColor() {
        if(!_border.isSetRight()) return null;

        CTBorderPr pr = _border.getRight();
        return new XSSFColor(pr.getColor());
    }
    public short getRightBorderColor() {
        XSSFColor color = getRightBorderColorColor();
        if (color == null) return 0;
        return color.getIndexed();
    }

    public XSSFColor getTopBorderColorColor() {
        if(!_border.isSetTop()) return null;

        CTBorderPr pr = _border.getTop();
        return new XSSFColor(pr.getColor());
    }
    public short getTopBorderColor() {
        XSSFColor color = getRightBorderColorColor();
        if (color == null) return 0;
        return color.getIndexed();
    }

    public void setBorderBottom(short border) {
        CTBorderPr pr = _border.isSetBottom() ? _border.getBottom() : _border.addNewBottom();
        if(border == BORDER_NONE) _border.unsetBottom();
        else pr.setStyle(STBorderStyle.Enum.forInt(border + 1));
    }

    public void setBorderDiagonal(short border) {
        CTBorderPr pr = _border.isSetDiagonal() ? _border.getDiagonal() : _border.addNewDiagonal();
        if(border == BORDER_NONE) _border.unsetDiagonal();
        else pr.setStyle(STBorderStyle.Enum.forInt(border + 1));
    }

    public void setBorderLeft(short border) {
        CTBorderPr pr = _border.isSetLeft() ? _border.getLeft() : _border.addNewLeft();
        if(border == BORDER_NONE) _border.unsetLeft();
        else pr.setStyle(STBorderStyle.Enum.forInt(border + 1));
    }

    public void setBorderRight(short border) {
        CTBorderPr pr = _border.isSetRight() ? _border.getRight() : _border.addNewRight();
        if(border == BORDER_NONE) _border.unsetRight();
        else pr.setStyle(STBorderStyle.Enum.forInt(border + 1));
    }

    public void setBorderTop(short border) {
        CTBorderPr pr = _border.isSetTop() ? _border.getTop() : _border.addNewTop();
        if(border == BORDER_NONE) _border.unsetTop();
        else pr.setStyle(STBorderStyle.Enum.forInt(border + 1));
    }

    public void setBottomBorderColor(Color color) {
        XSSFColor xcolor = XSSFColor.toXSSFColor(color);
        if (xcolor == null) setBottomBorderColor((CTColor)null);
        else setBottomBorderColor(xcolor.getCTColor());
    }
    public void setBottomBorderColor(short color) {
        CTColor ctColor = CTColor.Factory.newInstance();
        ctColor.setIndexed(color);
        setBottomBorderColor(ctColor);
    }
    public void setBottomBorderColor(CTColor color) {
        CTBorderPr pr = _border.isSetBottom() ? _border.getBottom() : _border.addNewBottom();
        if (color == null) {
            pr.unsetColor();
        } else {
            pr.setColor(color);
        }
    }

    public void setDiagonalBorderColor(Color color) {
        XSSFColor xcolor = XSSFColor.toXSSFColor(color);
        if (xcolor == null) setDiagonalBorderColor((CTColor)null);
        else setDiagonalBorderColor(xcolor.getCTColor());
    }
    public void setDiagonalBorderColor(short color) {
        CTColor ctColor = CTColor.Factory.newInstance();
        ctColor.setIndexed(color);
        setDiagonalBorderColor(ctColor);
    }
    public void setDiagonalBorderColor(CTColor color) {
        CTBorderPr pr = _border.isSetDiagonal() ? _border.getDiagonal() : _border.addNewDiagonal();
        if (color == null) {
            pr.unsetColor();
        } else {
            pr.setColor(color);
        }
    }

    public void setLeftBorderColor(Color color) {
        XSSFColor xcolor = XSSFColor.toXSSFColor(color);
        if (xcolor == null) setLeftBorderColor((CTColor)null);
        else setLeftBorderColor(xcolor.getCTColor());
    }
    public void setLeftBorderColor(short color) {
        CTColor ctColor = CTColor.Factory.newInstance();
        ctColor.setIndexed(color);
        setLeftBorderColor(ctColor);
    }
    public void setLeftBorderColor(CTColor color) {
        CTBorderPr pr = _border.isSetLeft() ? _border.getLeft() : _border.addNewLeft();
        if (color == null) {
            pr.unsetColor();
        } else {
            pr.setColor(color);
        }
    }

    public void setRightBorderColor(Color color) {
        XSSFColor xcolor = XSSFColor.toXSSFColor(color);
        if (xcolor == null) setRightBorderColor((CTColor)null);
        else setRightBorderColor(xcolor.getCTColor());
    }
    public void setRightBorderColor(short color) {
        CTColor ctColor = CTColor.Factory.newInstance();
        ctColor.setIndexed(color);
        setRightBorderColor(ctColor);
    }
    public void setRightBorderColor(CTColor color) {
        CTBorderPr pr = _border.isSetRight() ? _border.getRight() : _border.addNewRight();
        if (color == null) {
            pr.unsetColor();
        } else {
            pr.setColor(color);
        }
    }

    public void setTopBorderColor(Color color) {
        XSSFColor xcolor = XSSFColor.toXSSFColor(color);
        if (xcolor == null) setTopBorderColor((CTColor)null);
        else setTopBorderColor(xcolor.getCTColor());
    }
    public void setTopBorderColor(short color) {
        CTColor ctColor = CTColor.Factory.newInstance();
        ctColor.setIndexed(color);
        setTopBorderColor(ctColor);
    }
    public void setTopBorderColor(CTColor color) {
        CTBorderPr pr = _border.isSetTop() ? _border.getTop() : _border.addNewTop();
        if (color == null) {
            pr.unsetColor();
        } else {
            pr.setColor(color);
        }
    }
}
