package externals;
import java.util.*;

public class Kruskals {
	static int parent[] = new int [100];
	public static int find(int m) {
		int p = m;
		while(parent[p]!=0) {
			p=parent[p];
		}
		return p;
	}
	public static void union(int i,int j) {
		if(i<j) {
			parent[i] = j;
		}else
		{
			parent[j] = i;
		}
	}
	public void krkl(int g[][],int n) {
		int u=0,v=0,i,j,k=0,min,sum=0;
		while(k<n-1) {
			min=99;
			for(i=1;i<=n;i++) {
				for(j=1;j<=n;j++) {
					if(g[i][j]<min && i!=j) {
						min = g[i][j];
						u = i;
						v= j;
					}
				}
			}
			i = find(u);
			j = find(v);
			if(i!=j) {
				union(u,v);
				System.out.println("("+u+","+v+")" +"="+g[u][v]);
				sum+=g[u][v];
				k++;
			}
			g[u][v] = g[v][u]=  99;
		}
		System.out.println("The min cost is "+sum);
		
	}
	public static void main(String[] args) {
		int g[][] = new int[100][100];
		int n,u=0,v=0,i,j;
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the number of vertices");
		n = sc.nextInt();
		System.out.println("Enter the cost matrix");
		for(i=1;i<=n;i++) {
			for(j=1;j<=n;j++) {
				g[i][j] =sc.nextInt();
			}
		}
		Kruskals k = new Kruskals();
		k.krkl(g,n);
		
	}
}
