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
		

		for (int i = 1; i < 5; i++) {
		
			row = data.rows.get(i).row;
			
			cell1 = data.rows.get(i).cellContents.get(0);
			
			jobname += cell1 +" row# "+ row + ";";
			
			
			
			cell2 = data.rows.get(i).cellContents.get(1);
			
			secondcell();
			
			System.out.println();
			
			
			cell3 = data.rows.get(i).cellContents.get(2);//type of emploment
			
			//cell4 = data.rows.get(i).cellContents.get(3);
			
			cell5 = data.rows.get(i).cellContents.get(4);//compare to skillsneeded
			
			fithcell();
			//companyscorse[i] = tempscore;
			System.out.println(jobname);
			jobname = "";
			//jobnames = jobname.split(";");
			
			
			System.out.println("key things that commpanies want : ");
			System.out.println(skill);
			
			
			cell1 = "";
			cell2 = "";
			cell3 = "";
			cell4 = "";
			cell5 = "";
			tempscore = "";
		}
		jobnames = jobname.split(";");
		skills = skill.split(";");
	}

	private static void secondcell(){
		boolean keytest = true;
		while (keytest){
			int temp = cell2.indexOf(" ");
			if (temp<0){
				keytest = false;
				//System.out.print(skill + "");
				
			}else{
			String temp2 = cell2.substring(0, temp);
			//System.out.println(temp2);
			for (int j =0; j<keywordstowant.length; j++ ){
				if (temp2.endsWith(keywordstowant[j])){
					skill += keywordstowant[j] + ",";
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
		case ACCOUNTING:
			break;
		case ACTUARIAL_SCIENCE :
			break;
		case AERONAUTICAL_ASTRONAUTICAL_ENGINEERING:
			break;
		case AGRIBUSINESS_APPLIED:
			break;
		case AGRICULTURAL_ENVIRONMENTAL_DEVELOPMENTAL:
			break;
		case ANTHROPOLOGY:
			break;
		case ARABIC:
			break;
		case BIOLOGY:
			break;
		case BUSINESS:
			break;
		case BUSINESS_ADMINISTRATION:
			break;
		case CHEMISTRY:
			break;
		case CHINESE:
			break;
		case CIVIL_ENGINEERING:
			break;
		case COMMUNICATION:
			break;
		case COMPUTER_INFORMATION_SCIENCE:
			break;
		case COMPUTER_SCIENCE_ENGINEERING: 
			break;
		case CONSTITUTIONAL_LAW :
			break;
		case CONSUMER_FAMILY_FINANCIAL_SERVICES:
			break;
		case DATA_ANALYSIS:
			break;
		case DATA_ANALYTICS:
			break;
		case ECONOMICS:
			break;
		case ECONOMICS_BUSINESS:
			break;
		case ELECTRICAL_COMPUTER_ENGINEERING:
			break;
		case ENGINEERING:
			break;
		case ENGINEERING_PHYSICS:
			break;
		case ENGINEERING_SCIENCES: 
			break;
		case ENGLISH:
			break;
		case ENTREPRENEURSHIP:
			break;
		case ENVIRONMENT_ECONOMY_DEVELOPMENT_SUSTAINABILITY:
			break;
		case FINANCE :
			break;
		case FINANCIAL_MATHEMATICS:
			break;
		case FRENCH:
			break;
		case GENDER_STUDIES:
			break;
		case GEOGRAPHICAL_INFORMATION_SCIENCE :
			break;
		case GEOMATICS_ENGINEERING:
			break;
		case GERMAN:
			break;
		case HEALTH_INFORMATION_MANAGEMENT_SYSTEMS:
			break;
		case HISTORY :
			break;
		case INDUSTRIAL_SYSTEMS_ENGINEERING:
			break;
		case INFORMATION_SYSTEMS:
			break;
		case INTERNATIONAL_STUDIES:
			break;
		case LANDSCAPE_DESIGN_MANAGEMENT:
			break;
		case LEADERSHIP_STUDIES:
			break;
		case LINGUISTICS:
			break;
		case MATHEMATICAL_SCIENCES:
			break;
		case MATHEMATICS:
			break;
		case MECHANICAL_ENGINEERING:
			break;
		case ORGANIZATIONAL_COMMUNICATION:
			break;
		case PHILOSOPHY :
			break;
		case PHYSICS:
			break;
		case POLITICAL_SCIENCE:
			break;
		case PUBLIC_HEALTH:
			break;
		case PSYCHOLOGY :
			break;
		case SOCIOLOGY:
			break;
		case SOMALI:
			break;
		case SPANISH:
			break;
		case SPANISH_FOR_BUSINESS:
			break;
		case STATISTICS:
			break;
		case STRATEGIC_COMMUNICATION:
			break;
		case STRATEGIC_COMMUNICATIONS:
			break;
		case THEATRE:
			break;
		default:
			System.out.println("check major switch statement");
			break;
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
				skill += ";";
				//System.out.println(skill );
				
			}else{
			String temp2 = cell5.substring(0, temp);
			//System.out.println(temp2);
			for (int j =0; j<keywordstowant.length; j++ ){
				if (temp2.endsWith(keywordstowant[j])){
					skill += keywordstowant[j] + ",";
				}
			}
			cell5 = cell5.substring(temp +1);
			}
		}
		
		
	}



}
