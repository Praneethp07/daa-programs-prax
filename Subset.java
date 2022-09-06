package externals;
import java.util.*;
public class Subset {
	
	public static void subset(int num,int n,int x[]) {
		for(int i=1;i<=n;i++) {
			x[i] = 0;
		}
		for(int i=n;num!=0;i--) {
			x[i] = num%2;
			num/=2;
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int a[] = new int [200];
		int x[] = new int [100];
		
		boolean present = false;
		Scanner sc = new Scanner(System.in);
		System.out.println("ENter the no of elements");
		int n = sc.nextInt();
		System.out.println("ENter the array elements");
		for(int i=1;i<=n;i++) {
			a[i] = sc.nextInt();
		}
		System.out.println("Enter the value of d");
		int d = sc.nextInt();
		if(d>0) {
			for(int i = 1;i<=Math.pow(2, n)-1;i++) {
				
				subset(i,n,x);
				int sum  = 0;
				for(int j=1;j<=n;j++)
					if(x[j]==1)
					sum=sum+a[j];
				if(d == sum) {
					System.out.print("subset={");
					present = true;
					for(int j=1;j<=n;j++) {
						if(x[j] == 1) {
							System.out.print(a[j]+",");
						}
					}
					System.out.println("} = "+sum);
					System.out.println();
				}
			}
		}
		if(!present) {
			System.out.println("Solution doesnot exist");
		}
	}

}
