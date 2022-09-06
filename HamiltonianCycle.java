package externals;
import java.util.*;
public class HamiltonianCycle {
	static int x[] = new int[10];
	public static void Hcycle(int g[][],int n,int k) {
	int i;
	while(true) {
		nextValue(g,n,k);
		if(x[k] == 0) {
			return;
		}
		if(k == n) {
			for(i=1;i<=n;i++) {
				System.out.print(x[i]+"->");
			}
			System.out.println(x[1]);
		}else
		{
			Hcycle(g,n,k+1);
			
		}
	}
	
	
	}
	static void nextValue(int g[][],int n,int k) {
		int i=0;
		while(true) {
			
			x[k] = (x[k]+1)%(n+1);
			if(x[k] == 0) {
				return;
			}
			if(g[x[k-1]][x[k]] ==1) {
				for(i=1;i<=k-1;i++) {
					if(x[i] == x[k]) {
						break;
					}
				}
				if(i == k) {
					if((k<n) || ((k==n)  &&  (g[x[n]][x[1]]==1) )) {
						return;
					}
				}
			}
		}
	}
	public static void main(String[] args) {
		int g[][] = new int [100][100];
		int x1,x2,n,edges,i,j;
		System.out.println("Enter the no of vertices");
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		for(i=1;i<=n;i++)
		{
			for(j=1;j<=n;j++) {
				g[i][j] = 0;
				x[i] = 0;
			}
		}
		System.out.println("Enter the no of edges");
		edges = sc.nextInt();
		for(i=1;i<=edges;i++) {
			System.out.println("Enter the edge "+i+": ");
			x1 = sc.nextInt();
			x2 = sc.nextInt();
			g[x1][x2] = 1;
			g[x2][x1] = 1;
		}
		x[1] = 1;
		System.out.println("hamiltonian cycle");
		Hcycle(g,n,2);
		
	}
}
