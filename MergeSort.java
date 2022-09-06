package externals;

import java.util.Random;
import java.util.Scanner;

public class MergeSort 
{
	public static void divide(int a[],int low,int high) {
		if(low>=high) {
			return;
		}
		int mid = (low+high)/2;
		divide(a,low,mid);
		divide(a,mid+1,high);
		merge(a,low,mid,high);
		
	}
	public static void merge(int a[],int low,int mid,int high) {
		int merger[] = new int[high-low+1];
		int i=low;
		int j=mid+1;
		int x=0;
		while(i<=mid && j<=high)
		{
			if(a[i]<a[j]) {
				merger[x++] = a[i++];
			}
			else {
				merger[x++] = a[j++];
			}
		}
		while(i<=mid) {
			merger[x++] = a[i++];
		}
		while(j<=high) {
			merger[x++] = a[j++];
		}
//		for(int y=0,z=low;y<merger.length;z++,y++) {
//			a[z] = merger[y];
//		}
		int k =low;
		for(int z=0;z<merger.length;z++) {
			a[k++] = merger[z];
		}
		
	}
public static void main(String[] args) {
	Random r = new Random();
	int []a = new int[10000000];
	Scanner sc = new Scanner(System.in);
	System.out.println("enter the no of elements");
	int n = sc.nextInt();
//	System.out.println("enter the array elements");
	for(int i=0;i<n;i++) {
		a[i] = r.nextInt(100);
	}
	for(int i=0;i<n;i++) {
		System.out.print(a[i]+" ");
	}
	System.out.println();
//	MergeSort m = new MergeSort();
	divide(a, 0, n-1);
	//print
	for(int i=0;i<n;i++) {
		System.out.print(a[i]+" ");
	}
	System.out.println();
	
}
}
