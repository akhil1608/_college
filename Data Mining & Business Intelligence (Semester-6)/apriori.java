import java.util.Scanner;
public class apriori {
	static String item[],com[];
	static double c;
	static int n,s;
	public static void main(String args[]) {
		int i,j,k,ncr,cpc,fpc;
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter the number of transactions");
		n=sc.nextInt();
		item=new String[n];
		System.out.println("Enter itemset");
		for(i=0;i<n;i++)
			item[i]=sc.next();
		System.out.println("Enter min Support Count");
		s=sc.nextInt();
		System.out.println("Enter min Confidence in %");
		c=sc.nextDouble()/100;
		int l=letters()-64;
		String cp[]=new String[l];
		String fp[]=new String[l];
		for(i=0;i<l;i++) {
			cp[i]=""+(char)(65+i);
			fp[i]="";
		}
		i=2;
		cpc=l;
		fpc=l;
		while(i<=l) {
			fp=new String[cpc];
			fpc=0;
			for(j=0;j<cpc;j++)
				if(freq(cp[j])>=s)
					fp[fpc++]=cp[j];
			if(fpc<i)
				break;
			cp=new String[ncr(l,i)];
			cpc=0;
			for(j=0;j<fpc;j++)
				for(k=(int)fp[j].charAt(i-2)+1;k<=l+64;k++) {
					String temp=fp[j]+(char)k;
					if(filter(temp,fp,fpc,i))
						cp[cpc++]=temp;
				}
			i++;
		}
		System.out.println("Frequent Pattern:");
		for (j=0;j<fpc;j++) 
			System.out.println(fp[j]);
		System.out.println("Association rules: (Upto 2)");
		for(i=0;i<fpc;i++)
			if(fp[i].length()<3)
				for(j=0;j<1;j++) {
					String a=""+fp[i].charAt(0);
					double conf=(double)freq(fp[i])/freq(a);
					if(conf>=c)
						System.out.println(a+"->"+fp[i].charAt(1)+" ("+(conf*100)+"%)");
				}
	}
	private static int letters() {
		int i,j,max=65;
		for(i=0;i<n;i++)
			for(j=0;j<item[i].length();j++)
				if(item[i].charAt(j)>max)
					max=item[i].charAt(j);
		return max;
	}
	private static int freq(String g) {
		int i,j,k,f=0,fr=0;
		for(i=0;i<n;i++) {
			if(item[i].length()<g.length())
				continue;
			for(j=0;j<g.length();j++) {
				f=0;
				for(k=0;k<item[i].length();k++)
					if(item[i].charAt(k)==g.charAt(j)) {
						f++;
						break;
					}
				if(f==0)
					break;
			}
			if(f!=0)
				fr++;
		}
		return fr;
	}
	private static int ncr(int n,int r) {
		int i,ncr=n;
		for(i=1;i<r;i++) {
			ncr*=(n-i);
			ncr/=i;
		}
		return ncr/r;
	}
	private static boolean filter(String t,String fp[],int fpc,int n) {
		int i,count=0;
		String regex="["+t+"]*";
		for(i=0;i<fpc;i++) {
			if(fp[i].matches(regex))
				count++;
			if(count==n)
				return true;
		}
		return false;
	}
}