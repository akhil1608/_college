import java.util.Scanner;
import java.util.ArrayList;
import java.util.Collections;
class uniformity {
	// Kolgomorov-Smirnov Test
	private static void kolgomorov() {
		int i,n;
		Scanner sc = new Scanner(System.in);
		// Input from the user
		System.out.println("Specify the number of random numbers:");
		n = sc.nextInt();
		System.out.println("Enter the value of aplha (in %)");
		float a = (float)(sc.nextInt())/100;
		ArrayList<Float> random = new ArrayList<Float>();
		System.out.println("Enter "+n+" random numbers:");
		for(i=0;i<n;i++) {
			float input = sc.nextFloat();
			random.add(input);
		}
		// Creating an array list of dplus and dminus values
		ArrayList<Float> dplus = new ArrayList<Float>();
		ArrayList<Float> dminus = new ArrayList<Float>();
		Collections.sort(random); // Sort the list before performing any operations
		// Compute the dplus and sminus values
		for(i=0;i<n;i++) {
			float val = random.get(i);
			dplus.add((float)Math.round(((float)(i+1)/n-val)*100)/100);
			dminus.add((float)Math.round((val-(float)(i)/n)*100)/100);
		}
		// Print table
		System.out.println();
		System.out.print("i\t\t");
		for(i=1;i<=n;i++) System.out.print(i+"\t");
		System.out.println();
		System.out.print("Ri\t\t");
		for(i=0;i<n;i++) System.out.print(random.get(i)+"\t");
		System.out.println();
		System.out.print("i/N\t\t");
		for(i=1;i<=n;i++) System.out.print((float)i/n+"\t");
		System.out.println();
		System.out.print("i/N-Ri\t\t");
		for(i=0;i<n;i++) System.out.print(dplus.get(i)+"\t");
		System.out.println();
		System.out.print("Ri-(i-1)/N\t");
		for(i=0;i<n;i++) System.out.print(dminus.get(i)+"\t");
		System.out.println();
		System.out.println();
		// Max of dplus, dminus
		float d = Math.max(Collections.max(dplus),Collections.max(dminus));
		System.out.println("max of D+: "+Collections.max(dplus)+", max of D-: "+Collections.max(dminus));
		/* Calculating the approximate critical value of d at alpha%. 
		   Accuracy increases as the value of n increases */
		float d0 = (float)Math.sqrt(-Math.log(a/2)/(2*n));
		System.out.println("D: "+d+", D0: "+d0);
		// Test the hypothesis
		if(d<d0)
			System.out.println("Null Hypothesis accepted");
		else
			System.out.println("Null Hypothesis rejected");
	}
	// Chi Sqaure Test
	private static void chi() {
		int i,c,total=0;
		float chi = 0;
		Scanner sc = new Scanner(System.in);
		// Taking input from the user
		System.out.println("Enter number of columns");
		c = sc.nextInt();
		String[] names = new String[c];
		int[][] chimatrix = new int[3][c+1];
		float[] chivalues = new float[c];
		System.out.println("Enter names of each column");
		for(i=0;i<c;i++)
			names[i] = sc.next();
		System.out.println("Enter observed values");
		for(i=0;i<c;i++) {
			System.out.print(names[i]+" = ");
			chimatrix[0][i] = sc.nextInt();
			total += chimatrix[0][i];
		}
		chimatrix[0][c] = chimatrix[1][c] = total;
		System.out.println("Enter expected values");
		// Computing the chi sqaure value
		for(i=0;i<c;i++) {
			System.out.print(names[i]+" = ");
			chimatrix[1][i] = sc.nextInt(); // E
			chimatrix[2][i] = chimatrix[0][i]-chimatrix[1][i]; // O-E
			chivalues[i] = chimatrix[2][i]*chimatrix[2][i]/(float)chimatrix[1][i]; // (O-E)^2/E
			chi += chivalues[i]; // Summation of (O-E)^2/E
		}
		System.out.println();
		// Printing the chi square test table
		System.out.print("\t ");
		for(i=0;i<c;i++)
			System.out.print(names[i]+"  ");
		System.out.println("Total");
		System.out.print("Observed  ");
		for(i=0;i<=c;i++)
			System.out.print(chimatrix[0][i]+"\t");
		System.out.println();
		System.out.print("Expected  ");
		for(i=0;i<=c;i++)
			System.out.print(chimatrix[1][i]+"\t");
		System.out.println();
		System.out.print("O-E\t  ");
		for(i=0;i<c;i++)
			System.out.print(chimatrix[2][i]+"\t");
		System.out.println();
		System.out.print("(O-E)^2/E ");
		for(i=0;i<c;i++)
			System.out.print(chivalues[i]+"\t");
		System.out.println();
		System.out.println();
		System.out.println("Enter critical value of chi-square for degree of freedom "+(c-1)+" and level of significance of your choice");
		float chi0 = sc.nextFloat();
		// Testing the hypothesis
		if(chi<chi0)
			System.out.println("Null Hypothesis accepted");
		else
			System.out.println("Null Hypothesis rejected");
	}
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		int i,n,choice;
		System.out.println("Perform:\n1. Kolgomorov-Smirnov Test\n2. Chi Sqaure Test\nAny other key to exit");
		choice = sc.nextInt();
		System.out.println();
		switch(choice) {
			case 1: kolgomorov(); break;
			case 2: chi(); break;
			default: break;
		}
	}
}
