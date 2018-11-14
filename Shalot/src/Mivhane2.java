
public class Mivhane2 {
	public static int index (int []A) {
		int low=0;
		int high =A.length;
		int mid=(high+low)/2;
		while (low<high) {
			if(A[mid]>A[mid-1]&&A[mid]>A[mid+1]) {
				return mid;
				
			}
			else if(A[mid]<A[mid-1]) {
				high=mid;
				mid=(high+low)/2;
			}
			else {
				low=mid;
				mid=(high+low)/2;
			}
			
		}
		return mid;
	}
	
	public static void Mergesort(int[] array) {
		 Mergesort(array ,0,array.length);
	}
	
	public static void Mergesort(int []array ,int low,int high) {
		if(low<high-1) {
			int mid=(high+low)/2;
			Mergesort(array , low,mid);
			Mergesort(array, mid,high);
			int n=high-low;
			int []tmp=new int[n];
			int i=low;
			int j=mid;
			int k=0;
			
			while(i<mid&&j<high) {
				if(array[i]<array[j]) {
					tmp[k++]=array[i++];
					
				}
				else {
					tmp[k++]=array[j++];
				}
			}
			while(i<mid) {
				tmp[k++]=array[i++];
			}
			while(j<high) {
				tmp[k++]=array[j++];
				
			}
			for(int p=0;p<n;p++) {
				array[low+p]=tmp[p];
			}
		}
	}
}
