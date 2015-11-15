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
	
	private static String tempscore;
	// ideal job

	public String bestjob;
	static String[] companyscorse;	
	
	
	//list of jobs (requirments)

	private static String[] keywordstowant={"quantitative", "hands-on", "communication", "learn", "lead", "collaborate", "experience", "problem solving"," technical", "passion", "team", "interest", "analyze", "flexible","motivated"};
	
	public static String jobname = "";
	public static String[] jobnames;
	public static String envirment = "";
	public static String[] envirments;
	public static String mayjor = "";
	public static String[] mayjors;
	public static String skill = "";
	public static String[] skills;
	
	public static void main(String[] args) throws EncryptedDocumentException, InvalidFormatException, IOException {
		
		Reader inputer = new Reader();
		SheetData data = inputer.readToStructs(Paths.get("C:", "Users", "dogbi_000" , "Downloads", "Copy of TDA Jobs Data Test.xls" ));
		

	//	for (int i = 1; i < 262; i++) {
			row = data.rows.get(1).row;
			cell1 = data.rows.get(1).cellContents.get(0);
			jobname += cell1 + ";";
			
			cell2 = data.rows.get(1).cellContents.get(1);
			secondcell();
			
			cell3 = data.rows.get(1).cellContents.get(2);//type of emploment
			
			//cell4 = data.rows.get(i).cellContents.get(3);
			cell5 = data.rows.get(1).cellContents.get(4);//compare to skillsneeded
			fithcell();
			//companyscorse[i] = tempscore;
			tempscore = "";
		//}
		jobnames = jobname.split(";");
		skills = skill.split(";");
	}

	private static void secondcell(){
		boolean keytest = true;
		while (keytest){
			int temp = cell2.indexOf(" ");
			if (temp<0){
				keytest = false;
				System.out.println(skill);
				skill += ";";
			}else{
			String temp2 = cell2.substring(0, temp);
			System.out.println(temp2);
			for (int j =0; j<keywordstowant.length; j++ ){
				if (temp2.endsWith(keywordstowant[j])){
					skill += keywordstowant[j];
				}
			}
			cell2 = cell2.substring(temp +1);
			}
		}
		
		
	}
	private static void thirdcell(){
		String tempinput = "";
		MajorType major = MajorType.valueOf(tempinput);
		switch (major){
		
		
		
		}
	}
	private static void forthcell(){
		
	}
	private static void fithcell(){
		boolean keytest = true;
		while (keytest){
			int temp = cell5.indexOf(" ");
			if (temp<0){
				keytest = false;
				System.out.println(skill);
				skill += ";";
			}else{
			String temp2 = cell5.substring(0, temp);
			System.out.println(temp2);
			for (int j =0; j<keywordstowant.length; j++ ){
				if (temp2.endsWith(keywordstowant[j])){
					skill += keywordstowant[j];
				}
			}
			cell5 = cell5.substring(temp +1);
			}
		}
		
		
	}



}
