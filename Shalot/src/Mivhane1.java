
public class Mivhane1 {
	public static int index (int []A) {
		int low=0;
		int high =A.length;
		int mid=(low+high)/2;
		while(low<high) {
			if(A[mid-1]<A[mid]&&A[mid+1]<A[mid]) {
				low=high;
			}
			else if(A[mid]<A[mid-1]) {
				high=mid;
				mid=(low+high)/2;

			}
			else {
				low =mid;
				mid=(low+high)/2;
			}
		}
		return mid;
	}

	public static void Mergesort(int[] array) {
		mergesort(array,0,array.length);

	}

	public static void mergesort(int arr[],int low,int high) {
		if(low<high-1) {
			int mid=(high+low)/2;
			mergesort(arr, low, mid);
			mergesort(arr, mid, high);
			int n=high-low;
			int tmp[]=new int [n];
			int i=low;
			int j=mid;
			int k=0;

			while(i<mid&&j<high) {
				if(arr[i]<arr[j]) {
					tmp[k++]=arr[i++];

				}
				else {
					tmp[k++]=arr[j++];

				}

			}
			while(i<mid) {
				tmp[k++]=arr[i++];
			}
			while(j<high) {
				tmp[k++]=arr[j++];
			}
			for(int p=0;p<n;p++) {
				arr[low+p]=tmp[p];
			}
			}


		}
	
	public static int binarySearch(int[] A, int x) {
		if(A.length==0) {
			return -1;
		
		}
		else {
			return binarySearch(A, 0,A.length, x);
	}
	}
		public static int binarySearch(int[]arr,int low,int high,int x) {
			int mid=(high+low)/2;
			if(x==arr[mid]) {
				return mid;
				
			}
			if(low>=high-1) {
				return -1;
			}
			 if(x<arr[mid]) {
				return binarySearch(arr, low, mid, x);
			}
			 if(x>arr[mid]) {
				return binarySearch(arr, mid, high, x);
					
				}
		
			
				return -1;		
		}
	


	public static void main(String[] args) {
		//int[] arr= {2,13,42,57,61,37,26,15,14,5};
		//System.out.println(index(arr));
		
		int []arr= {24,3,2,30,10};
		Mergesort(arr);
		for(int i=0;i<arr.length;i++) {
			System.out.println(arr[i]);
		}
		
		System.out.println(binarySearch(arr, 25));
	}
}
