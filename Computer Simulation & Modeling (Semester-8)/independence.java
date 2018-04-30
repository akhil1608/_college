import java.util.Scanner;
class independence {
	private static void run() {
		Scanner sc = new Scanner(System.in);
		int i, num, s, runs = 1;
		double mew,sigma,z;
		System.out.println("Enter n");
		num = sc.nextInt();
		int[] seq = new int[num];
		System.out.println("Enter sequence of "+num+" numbers");
		for(i=0;i<num;i++) 
			seq[i] = sc.nextInt();
		System.out.println("1. Up/Down 2. Above/Below");
		int ch = sc.nextInt();
		switch(ch) {
			case 1:
			s = sign(seq[0],seq[1]);
			for(i=1;i<num;i++)
			if(sign(seq[i-1],seq[i])!=0) {
				if(sign(seq[i-1],seq[i])!=s)
					runs++;
				s = sign(seq[i-1],seq[i]);
			}
			mew = (2*num-1)/3.0;
			sigma = (16*num-29)/90.0;
			break;
			case 2:
			int p = 0, n = 0;
			s = sign(seq[0],0.495);
			if(s==1) p++;
			else n++;
			for(i=1;i<num;i++)
				if(sign(seq[i],0.495)!=0) {
					if(sign(seq[i],0.495)!=s)
						runs++;
					if(sign(seq[i],0.495)==1) p++;
					else n++;
					s = sign(seq[i],0.495);
				}
			mew = (2.0*p*n)/num+0.5;
			sigma = Math.sqrt(2.0*p*n*(2.0*p*n-num)/(num*num*num-num*num));
			break;
			default: break;
		}
		z = Math.abs(runs-mew)/sigma;
		System.out.println("Runs = "+runs+" Mean = "+mew+" S.D. = "+sigma);
		System.out.println("Enter the critical value of Z");
		double z0 = sc.nextDouble();
		System.out.println("Z = "+z+" Z0 = "+z0);
		if(z<z0) System.out.println("Null hypothesis accepted");
		else System.out.println("Null hypothesis rejected");
	}
	private static void poker() {
		Scanner sc = new Scanner(System.in);
		float d,o,s,num;
		System.out.println("Enter n");
		num = (float)sc.nextInt();
		System.out.println("Enter number of all different digits, one matching pair of digits, all same digits");
		d = (float)sc.nextInt();
		o = (float)sc.nextInt();
		s = (float)sc.nextInt();
		float ed = 0.72f*num; float eo = 0.27f*num; float es = 0.01f*num;
		float chi = (d-ed)*(d-ed)/ed; chi += (o-eo)*(o-eo)/eo; chi += (s-es)*(s-es)/es;
		System.out.println("Enter critical value of Chi-Square");
		float chi0 = sc.nextFloat();
		System.out.println("X = "+chi+" X0 = "+chi0);
		if(chi<chi0) System.out.println("Null hypothesis accepted");
		else System.out.println("Null hypothesis rejected");
	}
	private static int sign(double a,double b) {
		if(a==b) return 0;
		else {
			if(a<b) return 1;
			else  return -1;
		}
	}
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		int i,n,choice;
		System.out.println("Perform: 1. Runs Test 2. Poker Test (3 digit numbers) Any other key to exit");
		choice = sc.nextInt();
		System.out.println();
		switch(choice) {
			case 1: run(); break;
			case 2: poker(); break;
			default: break;
		}
	}
}
