import java.util.Scanner;
class variate {
	static Scanner sc = new Scanner(System.in);
	public static void main(String args[]) {
		int choice;
		do {
			System.out.println("Press: 1. Exponential 2. Uniform 3. Weibull 4. Triangular Any other key to exit");
			choice = sc.nextInt();
			switch(choice) {
				case 1: exp(); break;
				case 2: uni(); break;
				case 3: weib(); break;
				case 4: tri(); break;
				default: break;
			}
			System.out.println();
		}while(choice<=4&&choice>0);
	}
	private static void exp() {
		System.out.println("Enter lambda");
		double l = sc.nextDouble();
		System.out.println("Enter a random number");
		double r = sc.nextDouble();
		System.out.println("The random variate, X = "+(-Math.log(1-r)/l));
	}
	private static void weib() {
		System.out.println("Enter alpha");
		double a = sc.nextDouble();
		System.out.println("Enter beta");
		double b = sc.nextDouble();
		System.out.println("Enter a random number");
		double r = sc.nextDouble();
		System.out.println("The random variate, X = "+(a*Math.pow((-Math.log(1-r)),(1/b))));
	}
	private static void uni() {
		System.out.println("Enter a");
		double a = sc.nextDouble();
		System.out.println("Enter b");
		double b = sc.nextDouble();
		System.out.println("Enter a random number");
		double r = sc.nextDouble();
		System.out.println("The random variate, X = "+(a+(b-a)*r));
	}
	private static void tri() {
		System.out.println("Enter c");
		double c = sc.nextDouble();
		System.out.println("Enter a random number");
		double r = sc.nextDouble();
		if(r<=1/c)
			System.out.println("The random variate, X = "+(Math.sqrt(c*r)));
		else
			System.out.println("The random variate, X = "+(c-Math.sqrt(c*(c-1)*(1-r))));
	}
}
