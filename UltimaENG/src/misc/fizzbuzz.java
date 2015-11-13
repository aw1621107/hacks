package misc;

public class fizzbuzz {

	public static void main(String[] args) {

		int number = 0;
		String f = "fizz";// multible of 3
		String B = "buzz";// multible of 5
		int three = 3;
		int five = 5;

		while (number < 100) {

			number++;

			if (number == three) {
				if (number == 15) {
					System.out.println(f + B);
					three += 3;
				} else if (number != 15) {
					System.out.println(f);
					three += 3;
				}
			}
			if (number == five) {
				System.out.println(B);
				five += 5;
			} else if (number != five && number != three - 3) {

				System.out.println(number);
			}
		}

	}

}
