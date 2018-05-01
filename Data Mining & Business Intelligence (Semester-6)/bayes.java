import java.util.Scanner;
public class bayes {
	public static void main(String args[]) {
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter the number of values in dataset");
		int n=sc.nextInt();
		int i,j,k;
		int w[]=new int[n];
		String h[]=new String[n];
		String f[]=new String[n];
		System.out.println("Enter values of the dataset");
		for(i=0;i<n;i++) {
			h[i]=sc.next();
			w[i]=sc.nextInt();
			f[i]=sc.next();
		}
		System.out.println("Dataset");
		System.out.println("Height\tWeight\tFit");
		for(i=0;i<n;i++)
			System.out.println(h[i]+"\t"+w[i]+"\t"+f[i]);
		System.out.println("Enter Sample Data");
		String H=sc.next();
		int W=sc.nextInt();
		double pf=prob(f,"Yes",n);
		double postf=(prob(h,f,H,"Yes",n)*gauss(w,f,W,"Yes",n))/(prob(h,H,n)*gauss(w,W,n));
		System.out.println(postf);
		// Tall 75 Yes Short 70 Yes Medium 72 Yes Tall 80 No Medium 72 No Short 70 No
	}
	private static double gauss(int d[],int p,int n) {
		int i,sum=0;
		double vd=0;
		for(i=0;i<n;i++)
			sum+=d[i];
		double mean=(double)sum/n;
		double dd[]=new double[n];
		for(i=0;i<n;i++)
			dd[i]=d[i]-mean;
		for(i=0;i<n;i++)
			vd+=dd[i]*dd[i];
		vd=vd/n;
		return Math.exp(-(p-mean)*(p-mean)/(2*vd))/Math.sqrt(2*3.14*vd);
	}
	private static double gauss(int d1[],String d2[],int p,String c,int n) {
		int i,count=0,sum=0;
		double vd=0;
		for(i=0;i<n;i++)
			if(d2[i].equals(c)) {
				sum+=d1[i];
				count++;
			}
		double mean=(double)sum/count;
		double dd[]=new double[n];
		for(i=0;i<n;i++)
			if(d2[i].equals(c))
				dd[i]=d1[i]-mean;	
		for(i=0;i<n;i++)
			if(d2[i].equals(c))
				vd+=dd[i]*dd[i];
		vd=vd/count;
		return Math.exp(-(p-mean)*(p-mean)/(2*vd))/Math.sqrt(2*3.14*vd);
	}
	private static double prob(String d[],String p,int n) {
		int i,count=0;
		for(i=0;i<n;i++)
			if(d[i].equals(p))
				count++;
		return (double)count/n;
	}
	private static double prob(String d1[],String d2[],String p,String c,int n) {
		int i,count=0;
		for(i=0;i<n;i++)
			if(d1[i].equals(p)&&d2[i].equals(c))
				count++;
		return (double)count/n;
	}
}