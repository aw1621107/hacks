package algorithm;


public class Sorter {
	
	
	public static String temp = "Economics";

	public static int good = 0;
	public static int bad =  0;
	public static String job = "";
	
	private static Keywordfindrer kyfn = new Keywordfindrer();
	
	public static void main(String[] args) {
		if (temp.contentEquals("Economics") || temp.contentEquals("mathematics") || temp.contentEquals("Finance")) {
			
		} else if (temp.contentEquals("Analytics")) {
			
		} else if (temp.contentEquals("Science")) {

		} else if (temp.contentEquals("Communications")) {

		} else if (temp.contentEquals("Business")) {

		} else if (temp.contentEquals("Science;")) {

		} else if (temp.contentEquals("International")) {

		}

		/*
		 * education intern develper analyist engineer
		 */
	}

	private static void keyfinder(){
		kyfn.goodfind();
		kyfn.badfinder();
	}
	
	
}
