package algorithm;

import org.omg.CORBA.UNKNOWN;

public class Sorter {

	public static String input = "Economics; mathematics";

	public static String degree = "";

	public static String compatmajors;
	public static String compatdegree;

	public static int good = 0;
	public static int bad = 0;
	private static int jobpoints = 0;
	public static String job = "";
	private static Keywordfindrer kyfn = new Keywordfindrer();

	private static String[] posstudentMajor = { "Economics", "mathematics", "Finance", "Analytics", "Science", "Communications", "Business", "International" };
	private static String[] posibledegree = { "unknown", "does not care", "none", "associate in progress", "associate", "bachelor in progress", "bachelor", "master in progress", "master", "doctorate in progress" };

	public static void main(String[] args) {

		findMajors();
		input = "Economics; mathematics";
		System.out.println(compatmajors);
		
		finddegree();
		input = "master";
		System.out.println(compatdegree);
	}

	public static void finddegree() {
		DegreeLevel level = DegreeLevel.valueOf(input);
		switch (level) {
		case UNKNOWN:
			degree += "unknown;";
			break;
		case DONT_CARE:
			degree += "does not care;";
			break;
		case NONE:
			degree += "none;";
			break;
		case ASSOCIATE_IN_PROGRESS:
			degree += "associate in progress;";
			break;
		case ASSOCIATE:
			degree += "associate;";
			break;
		case BACHELOR_IN_PROGRESS:
			degree += "bachelor in progress;";
			break;
		case BACHELOR:
			degree += "bachelor;";
			break;
		case MASTER_IN_PROGRESS:
			degree += "master in progress;";
			break;
		case MASTER:
			degree += "master;";
			break;
		case DOCTORATE_IN_PROGRESS:
			degree += "doctorate in progress;";
			break;
		case DOCTORATE:
			degree += "doctorate;";
			break;
		}

		String[] temp3 = degree.split(";");
		String compatible = "";
		for (int i = 0; i < temp3.length; i++) {
			int temp31 = input.indexOf(posibledegree[i]);
			if (temp31 >= 0) {
				jobpoints++;
				compatible += posibledegree[i] + ";";
			}

		}
		System.out.println(compatible);
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
		compatmajors = temp2;
		
	}

	private static void keyfinder() {
		kyfn.goodfind();
		kyfn.badfinder();
	}

}
