
public class Factorial {

	public static void main(String[] args) {

		System.out.println(needleInAHaystack("hello world", "world"));

	}

	public static int factorial(int n) {

		if (n <= 0) {

			return n;

		} else {
			int sum = 1;
			for (int i = n; i > 0; i--) {

				sum = sum * i;

			}

			return sum;

		}

	}

	public static String spin() {



		int p = (int) (Math.random() * 10) + 1;
		int c = (int) (Math.random() * 7) + 2;
//		System.out.println(p);
//		System.out.println(c);
		if (p > c) {
			return "Player wins";
		} else if (c > p) {
			return "Computer wins";
		} else {
			return spin();
		}

	}
	
	public static int needleInAHaystack(String hay, String needle) {
		
		return hay.indexOf(needle);
		
		
	}

}
