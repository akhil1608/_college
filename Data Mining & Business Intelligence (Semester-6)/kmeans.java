import java.util.Scanner;
import java.util.Random;
public class kmeans {
	static double centroid[][];
	static int data[][],a,n,c;
	public static void main(String args[]) {
		Scanner sc=new Scanner(System.in);
		Random r=new Random();
		System.out.println("Enter the number of attributes in dataset");
		a=sc.nextInt();
		System.out.println("Enter the number of values in dataset");
		n=sc.nextInt();
		int i,j;
		data=new int[n][a+1];
		String h[]=new String[n];
		String f[]=new String[n];
		System.out.println("Enter values of the dataset");
		for(i=0;i<n;i++)
			for(j=0;j<a;j++)
				data[i][j]=sc.nextInt();
		System.out.println("Enter the number of clusters to be formed");
		c=sc.nextInt();
		centroid=new double[c][a];
		for(i=0;i<n;i++)
			data[i][a]=0;
		i=1;
		while(i<=c) { //initialize cluster centroids with random values
			int ran=r.nextInt(n);
			if(data[ran][a]==0)
				data[ran][a]=i;
			else
				continue;
			i++;
		}
		do {
			display();
			cent();
		} while(km()); //run loop until cluster remains the same
	}
	private static void display() {
		int i,j;
		System.out.println("Dataset");
		for(i=0;i<a+1;i++)
			System.out.print((char)('A'+i)+"\t");
		System.out.println();
		for(i=0;i<n;i++) {
			for(j=0;j<a+1;j++)
				System.out.print(data[i][j]+"\t");
			System.out.println();
		}
	}
	private static void cent() {
		int i,j,k,count;
		for(i=0;i<c;i++) //initialize Centroid
			for(j=0;j<a;j++)
				centroid[i][j]=0;
		for(i=0;i<c;i++) { //compute Centroid
			count=0;
			for(j=0;j<n;j++)
				if(data[j][a]==i+1) {
					for(k=0;k<a;k++) 
						centroid[i][k]+=data[j][k];
					count++;
				}
			for(k=0;k<a;k++)
				centroid[i][k]/=count;
		}
		for(i=0;i<c;i++) {
			for(j=0;j<a;j++)
				System.out.print(centroid[i][j]+" ");
			System.out.println();
		}
		System.out.println();
	}
	private static boolean km() {
		int i,j,k,init;
		boolean flag=false;
		double d,min=0;
		for(i=0;i<n;i++) {
			init=data[i][a];
			for(k=0;k<c;k++) {
				d=0;
				for(j=0;j<a;j++)
					d+=Math.abs(data[i][j]-centroid[k][j]); //Manhattan Distance
				if(k==0) { //1st iteration, min=d
					min=d;
					data[i][a]=k+1;
				}
				if(d<min) { //minimum distance
					min=d;
					data[i][a]=k+1;
				}
			}
			if(data[i][a]!=init) //check if there is any change in cluster
				flag=true;
		}
		return flag;
	}
}