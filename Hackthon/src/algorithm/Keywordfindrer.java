package algorithm;

public class Keywordfindrer extends Sorter {

	private int goodtemp = 0;
	private int badtemp = 0;
	
	
	static void goodfind() {
		String[] good = { "very", "lots", "interested" };
		for (int i = 0; i < good.length; i++) {
			System.out.println(i);
			if (Sorter.temp.contentEquals(good[i])) {
				
			}
		}
	}

	static void badfinder() {
		String[] bad = { "never", "not", "no", "can't" };

		for (int i = 0; i < bad.length; i++) {
			System.out.println(i);
			if (Sorter.temp.contentEquals(bad[i])) {
				System.out.println(bad[i]);
				
			}

		}
		Sorter.bad = badtemp;
	}


}
