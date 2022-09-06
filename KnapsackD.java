package externals;

import java.util.Scanner;

public class KnapsackD{
	
	void solve(int wt[],int val[],int W,int n) {
		int i,j;
		int k[][] = new int[n+1][W+1];
		for(i=0;i<=n;i++) {
			for(j=0;j<=W;j++) {
				if(i==0||j==0) {
					k[i][j] = 0;
					
				}
				else if(wt[i]>j) {
					k[i][j]=k[i-1][j];
					
				}else {
					k[i][j]=Math.max(val[i]+k[i-1][j-wt[i]],k[i-1][j]);
				}
			}
		}
		System.out.println("optimal solution: "+k[n][W]);
		int selected[] = new int[n+1];
		for(i=0;i<n+1;i++)
			selected[i]=0;
			i=n;
			j=W;
			while (i>0&&j>0)
			{
			if (k[i][j] !=k[i-1][j])
			{
			selected[i] = 1;
			j = j - wt[i];
			}
			i--;
			}
			System.out.println("\nItems selected : ");
			for ( i = 1; i < n + 1; i++)
			if (selected[i] == 1)
			System.out.print(i +" ");
			System.out.println();
	}
	
	
	
	
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		KnapsackD ks = new KnapsackD();
		System.out.println("Enter number of elements ");
		int n = scan.nextInt();
		int[] wt = new int[n + 1];
		int[] val = new int[n + 1];
		System.out.println("Enter weight of "+ n +" elements");
		for (int i = 1; i <= n; i++)
		wt[i] = scan.nextInt();
		System.out.println("Enter values of "+ n +" elements");
		for (int i = 1; i <= n; i++)
		val[i] = scan.nextInt();
		System.out.println("Enter knapsack capacity ");
		int W = scan.nextInt();
		ks.solve(wt, val, W, n);
	}
}