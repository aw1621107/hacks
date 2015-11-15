package algorithm;

public class Sorter {

	public static String input = "Economics; mathematics";

	public static String degree = "";

	public static String compatmajors;
	public static String compatdegree;
	private static int jobpoints = 0;

	public static int good = 0;
	public static int bad = 0;

	public static String job = "";
	private static Keywordfindrer kyfn = new Keywordfindrer();

	private static String[] posstudentMajor = { "Economics", "mathematics", "Finance", "Analytics", "Science", "Communications", "Business", "International" };
	private static String[] posibledegree = { "unknown", "does_not_care", "none", "associate_in_progress", "associate", "bachelor_in_progress", "bachelor", "master_in_progress", "master", "doctorate_in_progress" };

	public static void main(String[] args) {

		findMajors();
		input = "Economics; mathematics";
		System.out.println(compatmajors);

		input = "DONT_CARE";
		finddegree();
		System.out.println(compatdegree);
		
		
		grad date
		
	}

	public static void finddegree() {
		DegreeLevel level = DegreeLevel.valueOf(input);

		switch (level) {
		case UNKNOWN:
			degree += "unknown; ";
			break;
		case DONT_CARE:
			degree += "does_not_care; ";
			break;
		case NONE:
			degree += "none; ";
			break;
		case ASSOCIATE_IN_PROGRESS:
			degree += "associate_in_progress; ";
			break;
		case ASSOCIATE:
			degree += "associate;";
			break;
		case BACHELOR_IN_PROGRESS:
			degree += "bachelor_in_progress; ";
			break;
		case BACHELOR:
			degree += "bachelor; ";
			break;
		case MASTER_IN_PROGRESS:
			degree += "master_in_progress; ";
			break;
		case MASTER:
			degree += "master; ";
			break;
		case DOCTORATE_IN_PROGRESS:
			degree += "doctorate_in_progress; ";
			break;
		case DOCTORATE:
			degree += "doctorate; ";
			break;
		default:
			System.out.print("check_switch ");
			break;
		}
		input.trim();
		String temp2 = "";
		
		for (int i = 0; i < posibledegree.length; i++) {
			int temp3 = input.indexOf(posibledegree[i]);
			if (temp3 >= 0) {
				jobpoints++;
				temp2 += posibledegree[i] + ";";
				
			}
			
		}
		//compatdegree = temp2;
		
	}
		/*String[] temp3 = degree.split(" ");

		System.out.print(degree);
		String compatible = "";
		
		for (int i = 0; i < temp3.length; i++) {
			int temp31 = input.indexOf(posibledegree[i]);
			if (temp31 >= 0) {
				jobpoints++;
				compatible += posibledegree[i] + ";";
			}

		}
		compatdegree = compatible;*/
	//}

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
