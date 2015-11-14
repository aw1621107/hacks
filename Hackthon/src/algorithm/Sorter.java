package algorithm;

import org.omg.CORBA.UNKNOWN;

public class Sorter {

	public static String input = "Economics; mathematics";

	public static String degree = "";
	public static String compatmajors = "";

	public static int good = 0;
	public static int bad = 0;
	private static int jobpoints = 0;
	public static String job = "";
	private static Keywordfindrer kyfn = new Keywordfindrer();

	private static String[] posstudentMajor = { "Economics", "mathematics", "Finance", "Analytics", "Science", "Communications", "Business", "International" };
	private static String[] posibledegree;

	public static void main(String[] args) {

		findMajors();

	}

	public static void finddegree() {
		final DegreeLevel level = DegreeLevel.valueOf(input);
		switch (level) {
		case UNKNOWN:
			degree += "unknown";
			break;
		case DONT_CARE:
			degree += "does not care";
			break;
		case NONE:
			degree += "none";
			break;
		case ASSOCIATE_IN_PROGRESS:
			degree += "associate in progress";
			break;	
		case ASSOCIATE:
			degree += "associate";
			break;
		case BACHELOR_IN_PROGRESS:
			degree += "bachelor in progress";
			break;
		case BACHELOR:
			degree += "bachelor";
			break;
		case MASTER_IN_PROGRESS:
			degree += "master in progress";
			break;
		case MASTER:
			degree += "master";
			break;
		case DOCTORATE_IN_PROGRESS:
			degree += "doctorate in progress";
			break;
		case DOCTORATE:
			degree += "doctorate";
			break;
		}
		
		St 
		String compatible;
		for (int i = 0; i < ; i++) {
			int temp3 = input.indexOf(posstudentMajor[i]);
			if (temp3 >= 0) {
				jobpoints++;
				compatible += posstudentMajor[i] + ";";
			}

		}
		String temp4[] = temp2.split(";");
		for (int i = 0; i < temp4.length; i++) {
			System.out.println(temp4[i]);
		}
		
	}

	public static void findMajors() {
		input.trim();
		String temp2 = "";

		for (int i = 0; i < posstudentMajor.length; i++) {
			int temp3 = input.indexOf(posstudentMajor[i]);
			if (temp3 >= 0) {
				jobpoints++;
				temp2 += posstudentMajor[i] + ";";
			}

		}
		String temp4[] = temp2.split(";");
		for (int i = 0; i < temp4.length; i++) {
			System.out.println(temp4[i]);
		}
	}

	private static void keyfinder() {
		kyfn.goodfind();
		kyfn.badfinder();
	}

}
