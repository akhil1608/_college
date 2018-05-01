import java.util.Scanner;
public class correlation {
	public static void main(String args[]) {
		Scanner sc=new Scanner(System.in);
		System.out.println("Menu:\n1 for numerical data\n2 for categorical data");
		int c=sc.nextInt();
		switch(c) {
			case 1: coeff(); break;
			case 2: chi(); break;
			default: System.out.println("Wrong Option"); break;
		}
	}
	private static void coeff() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the number of values in dataset");
		int n=sc.nextInt();
		int i,dof=n-1;
		double x[]=new double[n];
		double y[]=new double[n];
		double xx[]=new double[n];
		double yy[]=new double[n];
		double row[]=new double[n];
		double sumx=0,sumy=0,avgx,avgy,sdx=0,sdy=0,xy=0,r;
		System.out.println("Enter "+n+" values for X");
		for(i=0;i<n;i++)
			x[i]=sc.nextInt();
		System.out.println("Enter "+n+" values for Y");
		for(i=0;i<n;i++)
			y[i]=sc.nextInt();
		//Sum
		for(i=0;i<n;i++) {
			sumx+=x[i];
			sumy+=y[i];
		}
		//Average
		avgx=sumx/n;
		avgy=sumy/n;
		//a-a'
		for(i=0;i<n;i++) {
			xx[i]=x[i]-avgx;
			yy[i]=y[i]-avgy;
		}
		//Standard Deviation
		for(i=0;i<n;i++) {
			xy+=xx[i]*yy[i];
			sdx+=xx[i]*xx[i];
			sdy+=yy[i]*yy[i];
		}
		sdx=Math.sqrt(sdx/n);
		sdy=Math.sqrt(sdy/n);
		//Coefficient of Correlation
		r=xy/(n*sdx*sdy);
		r=(double)Math.round(r*100)/100;
		System.out.println("Coefficient of correlation is "+r);
	}
	private static void chi() {
		Scanner sc = new Scanner(System.in);
		String a,b,c,d;
		int[] xo=new int[2];
		int[] yo=new int[2];
		int[] xe=new int[2];
		int[] ye=new int[2];
		int i,xs=0,ys=0,sx=0,sy=0,t=0,dof=1;
		double chi=0,chi0=3.67;
		System.out.println("Assumption: Only four categories");
		System.out.println("Enter Category row-wise");
		a=sc.nextLine();
		b=sc.nextLine();
		System.out.println("Enter Category column-wise");
		c=sc.nextLine();
		d=sc.nextLine();
		System.out.println("Enter observed values");
		for(i=0;i<2;i++) {
			xo[i]=sc.nextInt();
			xs=xs+xo[i];
		}
		for(i=0;i<2;i++) {
			yo[i]=sc.nextInt();
			ys=ys+yo[i];
		}
		sx=xo[0]+yo[0];
		sy=xo[1]+yo[1];
		t=sx+sy;
		System.out.println("Observed:");
		System.out.println("\t"+a+"\t"+b+"\tTotal");
		System.out.println(c+"\t"+xo[0]+"\t"+xo[1]+"\t\t"+xs);
		System.out.println(d+"\t"+yo[0]+"\t"+yo[1]+"\t\t"+ys);
		System.out.println("Total\t"+sx+"\t"+sy+"\t\t"+t);
		//Expected Values
		xe[0]=sx*xs/t;
		xe[1]=xs-xe[0];
		ye[0]=sx-xe[0];
		ye[1]=ys-ye[0];
		System.out.println("Expected:");
		System.out.println("\t"+a+"\t"+b+"\tTotal");
		System.out.println(c+"\t"+xe[0]+"\t"+xe[1]+"\t\t"+xs);
		System.out.println(d+"\t"+ye[0]+"\t"+ye[1]+"\t\t"+ys);
		System.out.println("Total\t"+sx+"\t"+sy+"\t\t"+t);
		//Chi
		for (i=0;i<2;i++)
			chi+=(double)(xo[i]-xe[i])*(xo[i]-xe[i])/xe[i]+(double)(yo[i]-ye[i])*(yo[i]-ye[i])/ye[i];
		System.out.println("Chi Sqaure "+chi);
		System.out.println("Degree Of Freedom: "+dof+" Chi0 sqaure: "+chi0);
		if(chi<chi0)
			System.out.println("Null Hypothesis accepted. Playing and Gender are independent of each other");
		else
			System.out.println("Null Hypothesis rejected. There is some relation between Playing and Gender");
	}
}