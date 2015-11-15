package algorithm;

import java.io.IOException;
import java.nio.file.Paths;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;

import io.Reader;
import io.SheetData;
import io.SheetData.RowData;

public class Companysorter {

	public static int row;
	public static String cell1;
	public static String cell2;
	public static String cell3;
	public static String cell4;
	public static String cell5;
	
	private static int tempscore = 0;
	// ideal job

	public String bestjob;
	static String[] companyscorse;	
	public static void main(String[] args) throws EncryptedDocumentException, InvalidFormatException, IOException {

		Reader inputer = new Reader();
		SheetData data = inputer.readToStructs(Paths.get("C:", "Users", "dogbi_000" , "Downloads", "Copy of TDA Jobs Data Test.xls" ));
		
		
		for (int i = 1; i < 262; i++) {
			row = data.rows.get(i).row;
			cell1 = data.rows.get(i).cellContents.get(1);
			cell2 = data.rows.get(i).cellContents.get(2);
			cell3 = data.rows.get(i).cellContents.get(3);
			cell4 = data.rows.get(i).cellContents.get(4);
			cell5 = data.rows.get(i).cellContents.get(5);
			
			//companyscorse[i] = tempscore;
			tempscore = 0;
		}

	}

}
