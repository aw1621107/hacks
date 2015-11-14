package algorithm;

public class Sorter {

	public static String temp = "Economics; mathematics";

	public static int good = 0;
	public static int bad = 0;
	private static int majorpoints = 0;
	public static String job = "";
	private static Keywordfindrer kyfn = new Keywordfindrer();

	private static String[] posstudentMajor = { "Economics", "mathematics", "Finance", "Analytics", "Science", "Analytics", "Communications", "Business", "International" };

	public static void main(String[] args) {

		findMajors();
	}

	public static void findMajors() {
		temp.trim();
		String temp2 = "";

		for (int i = 0; i < posstudentMajor.length; i++) {

			int temp3 = temp.indexOf(posstudentMajor[i]);

			if (temp3 >= 0) {

				// System.out.println(temp3 + " " + posstudentMajor[i]);
				majorpoints++;
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
