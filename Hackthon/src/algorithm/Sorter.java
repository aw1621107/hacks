package algorithm;

import java.util.Arrays;

public class Sorter {

	public static String temp = "Economics";

	public static int good = 0;
	public static int bad = 0;
	public static String job = "";

	private static Keywordfindrer kyfn = new Keywordfindrer();

	public static void main(String[] args) {

		String[] studentMajor = { "Economics", "mathematics", "Finance", "Analytics", "Science", "Analytics", "Communications", "Business", "International" };
		
	}

	public static String[] findMajors(String studentMajor, String jobMajors) {

		studentMajor = studentMajor.toLowerCase();
		jobMajors = jobMajors.toLowerCase();
		
		String[] studentMajors = studentMajor.split("; ");
		
		String[] matches = new String[studentMajors.length];

		int counter = 0;

		for (String major : studentMajors) {

			int index = jobMajors.indexOf(major);
			String before = " ";
			String after = " ";
			if (index > 0) {
				before = jobMajors.substring(index - 1, index);
			}
			if (index + major.length() < jobMajors.length()) {
				after = jobMajors.substring(index + major.length() + 1, index + major.length() + 2);
			}
			if (((before.compareTo("a") < 0) || (before.compareTo("z") > 0)) && ((after.compareTo("a") < 0) || (after.compareTo("z") > 0))) {
				matches[counter] = major;
				counter++;
			}
		}
		String[] onlyMatches = new String[counter];
		for (int i = 0; i < counter; i++) {
			onlyMatches[i] = matches[i];
		}
		return onlyMatches;
	}

	/*
	 * if (temp.contentEquals("Economics") || temp.contentEquals("mathematics")
	 * || temp.contentEquals("Finance")) {
	 * 
	 * } else if (temp.contains("Analytics")) {
	 * 
	 * } else if (temp.contains(","")) {
	 * 
	 * } else if (temp.contentEquals("Communications")) {
	 * 
	 * } else if (temp.contentEquals("Business")) {
	 * 
	 * } else if (temp.contentEquals("Science;")) {
	 * 
	 * } else if (temp.contentEquals("International")) {
	 * 
	 * }
	 * 
	 * /* education intern develper analyist engineer
	 */

	private static void keyfinder() {
		kyfn.goodfind();
		kyfn.badfinder();
	}

}
