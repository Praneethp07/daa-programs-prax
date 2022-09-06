package externals;
import java.util.Scanner;
public class Dijkstras {
	int d[] = new int [10];
	int p[] = new int[10];
	int visited[] = new int [10];
 	void dijk(int g[][],int s,int n) {
 		int i,j,v,u=-1,min;
 		for(v=1;v<=n;v++) {
 			d[v] = 99;
 			p[v] = -1;
 		}
 		d[s] = 0;
 		for(i=0;i<=n;i++) {
 			min = 99;
 			for(j=1;j<=n;j++) {
 				if(d[j]<min && visited[j]==0) {
 					min = d[j];
 					u = j;
 				}
 			}
 			visited[u] = 1;
 			for(v=1;v<=n;v++) {
 				if(d[v]>d[u]+g[u][v] && (u!=v) && (visited[v]==0))
 				{
 					d[v] = d[u]+g[u][v];
 					p[v] = u;
 				}
 			}
 		}
 		
 		
	}
 	public void path(int v,int s) {
 		if(p[v]!=-1) {
 			path(p[v],s);
 		}
 		if(v!=s)
 		{
 			System.out.print("->"+v+" ");
 		}
 		
 		
 	}
 	public void display(int s,int n) {
 		int i;
 		for(i=1;i<=n;i++) {
 			if(i!=s) {
 				System.out.print(s+" ");
 				path(i,s);
 			}
 			if(i!=s) {
 				System.out.print("="+d[i]+" ");
 				System.out.println();
 			}
 		}
 	}

	public static void main(String[] args) {
		int graph[][] = new int[10][10];
		Scanner sc = new Scanner(System.in);
		int i,j,n,s;
		System.out.println("enter the no of vertex");
		n = sc.nextInt();
		System.out.println("enter the weighed matrix");
		for(i = 1;i<=n;i++) {
			for(j=1;j<=n;j++) {
				graph[i][j] = sc.nextInt();
			}
		}
		System.out.println("enter the starting vertex");
		s = sc.nextInt();
		Dijkstras obj = new Dijkstras();
		obj.dijk(graph, s, n);
		System.out.println("the shortest path between source"+s+"to remaining vertices are");
		obj.display(s, n);                                     
		sc.close();

	}

}
