package externals;
import java.util.*;
public class Prims {

	public static void main(String[] args) {
		int sol[] = new int[100];
		int a[][] = new int[10][10];
		int n,u=0,v=0,sum=0,flag=0,s,min;
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the number of vertices");
		n = sc.nextInt();
		System.out.println("Enter the vertices");
		for(int i=1;i<=n;i++) {
			for(int j=1;j<=n;j++) {
				a[i][j] = sc.nextInt();
			}
		}
		for(int i=1;i<=n;i++) {
			sol[i] = 0;
		}
		System.out.println("Enter the source vertices");
		s= sc.nextInt();
		sol[s] = 1;
		int k = 1;
		sum=0;
		while(k<=n-1) {
			min = 99;
			for(int i=1;i<=n;i++) {
				for(int j=1;j<=n;j++)
				{
					if(sol[i] == 1 && sol[j] == 0) {
						if(a[i][j]<min && i!=j) {
							min = a[i][j];
							u = i;
							v = j;
						}
					}
				}
			}
			sol[v] = 1;
			sum+=min;
			System.out.println("{"+u+"-->"+v+"}"+"="+min);
			k++;
		}
		for(int i=1;i<=n;i++) {
			if(sol[i] == 1) {
				flag = 1;
			}else
			{
				flag = 0;
			}
		}
		if(flag == 1)
		{
			System.out.println("The min sum of spanning tree is"+sum);
		}else {
			System.out.println("no spanning tree found");
		}
	}

}
