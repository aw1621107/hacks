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
	private static int[] countnum={0, 0, 0, 0, 0, 0, 0, 0,0, 0, 0,0, 0, 0,0};
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
		

		for (int i = 0; i < 242; i++) {
		
			row = data.rows.get(i).row;
			
			cell1 = data.rows.get(i).cellContents.get(0);
			
			jobname += cell1 +" row# "+ row + ";";
			
			
			cell2 = data.rows.get(i).cellContents.get(1);
			
			secondcell();
			
			System.out.println();
			
			cell3 = data.rows.get(i).cellContents.get(2);//type of emploment
			
			cell4 = data.rows.get(i).cellContents.get(3);//required majors
			//fourthcell();
			
			cell5 = data.rows.get(i).cellContents.get(4);//compare to skillsneeded
			fithcell();
			//companyscorse[i] = tempscore;
			System.out.println(jobname);
			
			//jobnames = jobname.split(";");
			
			
			System.out.println("key things that commpanies want : ");
			System.out.println(skill);
			System.out.println("prefered majors are : ");
			//System.out.print(mayjor);
			
			jobname = "";
			skill = "";
			cell1 = "";
			cell2 = "";
			cell3 = "";
			cell4 = "";
			cell5 = "";
			tempscore = "";
		}
		jobnames = jobname.split(";");
		skills = skill.split(";");
		System.out.println();
		for (int z= 0; z <keywordstowant.length; z++){
		System.out.print(keywordstowant[z] + " ");
		System.out.print(countnum[z] + " times, ");
		}
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
					countnum[j]++;
				}
			}
			cell2 = cell2.substring(temp +1);
			}
		}
		
		
	}
	private static void fourthcell(){
		cell4.toUpperCase();
		String tempinput =cell4;
		MajorType majortemp = MajorType.valueOf(tempinput);
		switch (majortemp){
		case ACCOUNTING:
			mayjor +="ACCOUNTING";
			break;
		case ACTUARIAL_SCIENCE :
			mayjor +="ACTUARIAL_SCIENCE";
			break;
		case AERONAUTICAL_ASTRONAUTICAL_ENGINEERING:
			mayjor +="AERONAUTICAL_ASTRONAUTICAL_ENGINEERING";
			break;
		case AGRIBUSINESS_APPLIED:
			mayjor +="AGRIBUSINESS_APPLIED";
			break;
		case AGRICULTURAL_ENVIRONMENTAL_DEVELOPMENTAL:
			mayjor +="AGRICULTURAL_ENVIRONMENTAL_DEVELOPMENTAL";
			break;
		case ANTHROPOLOGY:
			mayjor +="ANTHROPOLOGY";
			break;
		case ARABIC:
			mayjor +="ARABIC";
			break;
		case BIOLOGY:
			mayjor +="BIOLOGY";
			break;
		case BUSINESS:
			mayjor +="BUSINESS";
			break;
		case BUSINESS_ADMINISTRATION:
			mayjor +="BUSINESS_ADMINISTRATION";
			break;
		case CHEMISTRY:
			mayjor +="BUSINESS_ADMINISTRATION";
			break;
		case CHINESE:
			mayjor +="CHINESE";
			break;
		case CIVIL_ENGINEERING:
			mayjor +="CIVIL_ENGINEERING";
			break;
		case COMMUNICATION:
			mayjor +="COMMUNICATION";
			break;
		case COMPUTER_INFORMATION_SCIENCE:
			mayjor +="COMPUTER_INFORMATION_SCIENCE";
			break;
		case COMPUTER_SCIENCE_ENGINEERING: 
			mayjor +="COMPUTER_SCIENCE_ENGINEERING";
			break;
		case CONSTITUTIONAL_LAW :
			mayjor +="CONSTITUTIONAL_LAW";
			break;
		case CONSUMER_FAMILY_FINANCIAL_SERVICES:
			mayjor +="CONSUMER_FAMILY_FINANCIAL_SERVICES";
			break;
		case DATA_ANALYSIS:
			mayjor +="DATA_ANALYSIS";
			break;
		case ECONOMICS:
			mayjor +="ECONOMICS";
			break;
		case ECONOMICS_BUSINESS:
			mayjor +="ECONOMICS_BUSINESS";
			break;
		case ELECTRICAL_COMPUTER_ENGINEERING:
			mayjor +="ELECTRICAL_COMPUTER_ENGINEERING";
			break;
		case ENGINEERING:
			mayjor +="ENGINEERING";
			break;
		case ENGINEERING_PHYSICS:
			mayjor +="ENGINEERING_PHYSICS";
			break;
		case ENGINEERING_SCIENCES: 
			mayjor +="ENGINEERING_SCIENCES";
			break;
		case ENGLISH:
			mayjor +="ENGLISH";
			break;
		case ENTREPRENEURSHIP:
			mayjor +="ENTREPRENEURSHIP";
			break;
		case ENVIRONMENT_ECONOMY_DEVELOPMENT_SUSTAINABILITY:
			mayjor +="ENVIRONMENT_ECONOMY_DEVELOPMENT_SUSTAINABILITY";
			break;
		case FINANCE :
			mayjor +="FINANCE";
			break;
		case FINANCIAL_MATHEMATICS:
			mayjor +="FINANCIAL_MATHEMATICS";
			break;
		case FRENCH:
			mayjor +="FRENCH";
			break;
		case GENDER_STUDIES:
			mayjor +="GENDER_STUDIES";
			break;
		case GEOGRAPHICAL_INFORMATION_SCIENCE :
			mayjor +="GEOGRAPHICAL_INFORMATION_SCIENCE";
			break;
		case GEOMATICS_ENGINEERING:
			mayjor +="GEOMATICS_ENGINEERING";
			break;
		case GERMAN:
			break;
		case HEALTH_INFORMATION_MANAGEMENT_SYSTEMS:
			mayjor +="HEALTH_INFORMATION_MANAGEMENT_SYSTEMS";
			break;
		case HISTORY :
			break;
		case INDUSTRIAL_SYSTEMS_ENGINEERING:
			mayjor +="INDUSTRIAL_SYSTEMS_ENGINEERING";
			break;
		case INFORMATION_SYSTEMS:
			mayjor +="INFORMATION_SYSTEMS";
			break;
		case INTERNATIONAL_STUDIES:
			mayjor +="INTERNATIONAL_STUDIES";
			break;
		case LANDSCAPE_DESIGN_MANAGEMENT:
			mayjor +="LANDSCAPE_DESIGN_MANAGEMENT";
			break;
		case LEADERSHIP_STUDIES:
			mayjor +="LEADERSHIP_STUDIES";
			break;
		case LINGUISTICS:
			mayjor +="LINGUISTICS";
			break;
		case MATHEMATICAL_SCIENCES:
			mayjor +="MATHEMATICAL_SCIENCES";
			break;
		case MATHEMATICS:
			mayjor +="MATHEMATICS";
			break;
		case MECHANICAL_ENGINEERING:
			mayjor +="MECHANICAL_ENGINEERING";
			break;
		case ORGANIZATIONAL_COMMUNICATION:
			mayjor +="ORGANIZATIONAL_COMMUNICATION";
			break;
		case PHILOSOPHY :
			mayjor +="PHILOSOPHY";
			break;
		case PHYSICS:
			mayjor +="PHYSICS";
			break;
		case POLITICAL_SCIENCE:
			mayjor +="POLITICAL_SCIENCE";
			break;
		case PUBLIC_HEALTH:
			mayjor +="PUBLIC_HEALTH";
			break;
		case PSYCHOLOGY :
			mayjor +="PSYCHOLOGY";
			break;
		case SOCIOLOGY:
			mayjor +="SOCIOLOGY";
			break;
		case SOMALI:
			mayjor +="SOMALI";
			break;
		case SPANISH:
			mayjor +="STATISTICS";
			break;
		case SPANISH_FOR_BUSINESS:
			mayjor +="STATISTICS";
			break;
		case STATISTICS:
			mayjor +="STATISTICS";
			break;
		case STRATEGIC_COMMUNICATION:
			mayjor +="STRATEGIC_COMMUNICATION";
			break;
		case STRATEGIC_COMMUNICATIONS:
			mayjor +="STRATEGIC_COMMUNICATIONS";
			break;
		case THEATRE:
			mayjor +="THEATRE";
			break;
		default:
			System.out.println("check major switch statement");
			break;
		}
	}
	private static void thirdcell(){
		
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
