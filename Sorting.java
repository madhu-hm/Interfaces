package assignment12;
import java.util.Scanner;

interface Sortable{
	void sort(int[] arr);
}

class BubbleSort implements Sortable{
	public void sort(int[] arr) {
		int n=arr.length;
		for(int i=0;i<n-1;i++) {
			for(int j=0;j<n-1-i;j++) {
				if(arr[j]>arr[j+1]) {
					int temp=arr[j];
					arr[j]=arr[j+1];
					arr[j+1]=temp;
				}
			}
		}
	}
}

class QuickSort implements Sortable{
	public void sort(int[] arr) {
		quickSort(arr,0,arr.length-1);
	}
	private void quickSort(int[]arr,int low,int high) {
		if(low<high) {
			int s=segment(arr,low,high);
			quickSort(arr,low,s-1);
			quickSort(arr,s+1,high);
		}
	}
	private int segment(int[]arr,int low,int high) {
		int pivot=arr[high];
		int i=low-1;
		for(int j=low;j<high;j++) {
			if(arr[j]<=pivot) {
				i++;
				int temp=arr[i];
				arr[i]=arr[j];
				arr[j]=temp;
			}
		}
		int temp=arr[i+1];
		arr[i+1]=arr[high];
		arr[high]=temp;
		return i+1;
	}
}

class MergeSort implements Sortable {
	
	public void sort(int[] arr) {
		mergeSort(arr, arr.length);
	}
	public static void mergeSort(int[] a, int n) {
	    if (n < 2) {
	        return;
	    }
	    int mid = n / 2;
	    int[] l = new int[mid];
	    int[] r = new int[n - mid];

	    for (int i = 0; i < mid; i++) {
	        l[i] = a[i];
	    }
	    for (int i = mid; i < n; i++) {
	        r[i - mid] = a[i];
	    }
	    mergeSort(l, mid);
	    mergeSort(r, n - mid);

	    merge(a, l, r, mid, n - mid);
	}
	public static void merge(
			int[] a, int[] l, int[] r, int left, int right) {
			int i = 0, j = 0, k = 0;
			while (i < left && j < right) {
				if (l[i] <= r[j]) {
					a[k++] = l[i++];
			    }
			    else {
			        a[k++] = r[j++];
			    }
			}
			while (i < left) {
			    a[k++] = l[i++];
			}
			while (j < right) {
			    a[k++] = r[j++];
			}
	}
	
}

public class Sorting {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		
		System.out.print("Enter number of elements: ");
		int n=sc.nextInt();
		int[] arr=new int[n];
		
		System.out.println("Enter elements: ");
		for(int i=0;i<n;i++) {
			arr[i]=sc.nextInt();
		}
		
		System.out.println("Choosing sorting algorithm:");
		System.out.println("1.Bubble Sort");
		System.out.println("2.Quick Sort");
		System.out.println("3.Merge Sort");
		int choice=sc.nextInt();
		
		Sortable sorter;
		
		switch(choice) {
			case 1->sorter=new BubbleSort();
			case 2->sorter=new QuickSort();
			case 3->sorter=new MergeSort();
			default->{
				System.out.println("Invalid choice!");
				sc.close();
				return;
			}
		}
		
		sorter.sort(arr);
		
		System.out.println("Sorted array: ");
		for(int num:arr) {
			System.out.println(num+" ");
		}
	}

}
