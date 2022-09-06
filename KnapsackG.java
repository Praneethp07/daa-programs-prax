package externals;

import java.util.Scanner;
public class KnapsackG {
	public static void main(String[] args) {
		int varcap, n,i=0,j,k=0,capacity;
		int [] profit = new int[20];
		int weights[] = new int [20];
		float PbyW[] = new float[20];
		float max =0,sum =0;
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter the number of items");
		n = sc.nextInt();
		int [] visited = new int [n+1];
		System.out.println("Enter the weights");
		for(i=1;i<=n;i++)
			weights[i] = sc.nextInt();
		System.out.println("Enter the profits");
		for(j=1;j<=n;j++) {
			profit[j] = sc.nextInt();
			
		}
		for(i=1;i<=n;i++) {
			PbyW[i] = ((float)profit[i]/(float)weights[i]);
		}
		System.out.println("Enter the max capacity");
		capacity = sc.nextInt();
		varcap = capacity;
		for(i=1;i<=n;i++) {
			visited[i] = 0;
		}
		while(varcap>=0) {
			max=0;
			for(i=1;i<=n;i++) {
				if(PbyW[i]>max)
				{
					max = PbyW[i];
					k=i;
				}
			}
				visited[k] = 1;
				PbyW[k] = 0;
				if(varcap<weights[k]) {
					sum+=max*varcap;
					varcap = -1;
				}else {
					sum+=(float)profit[k];
					varcap-=weights[k];
				}
			}
		for(i=1;i<=n;i++) {
			if(visited[i] ==1 ) {
				System.out.print(i+" ");
				
			}
		}
		System.out.println();
		System.out.println("total profit :"+sum);
	}
}

