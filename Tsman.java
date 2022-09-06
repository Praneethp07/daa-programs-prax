package externals;
import java.util.*;
public class Tsman {
	int min_dist;
	int a[][] = new int[100][100];
	int v[] = new int[10];
	public void mindist(int city,int n) {
		int ncity;
		v[city] = 1;
		System.out.print(city+"-->");
		ncity = least_option(city,n);
		if(ncity == 999) {
			ncity = 1;
			System.out.println(ncity);
			min_dist += a[city][ncity];
			return;
		}
		mindist(ncity,n);
	}
	public int least_option(int c,int n)
	{
		int min =999,kmin = 999,nc = 999;
		for(int i=1;i<=n;i++) {
			if((a[c][i]!=0) && (v[i] == 0))
				if(a[c][i]<min) {
					min = a[i][1]+a[c][i];
					kmin = a[c][i];
					nc=i;
				}
		}
		if(min!=999) {
			min_dist+=kmin; 
		}
		return nc;

	}
	public Tsman() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the number of cities");
		int n = sc.nextInt();
		System.out.println("Enter the cost matrix");
		for(int i=1;i<=n;i++) {
			for(int j=1;j<=n;j++) {
				this.a[i][j] = sc.nextInt();
				this.v[i] = 0;
			}
		}
		System.out.println("The optimum path is");
		this.mindist(1, n);
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Tsman t = new Tsman();
		System.out.println("min cost is "+t.min_dist);
		
	}

}
