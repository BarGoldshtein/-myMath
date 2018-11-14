package algo1;

public class Week4 {

	public static void main(String[] args) {
		int [] arr= {12,17,1,7,20,8,3,2,18,14};
		hamdani(arr);
		bySum(arr);
	}

	public static void hamdani(int []arr) {
		int alice=0;
		int bob=0;
		int start=0;
		int end=arr.length-1;
		while (start<end) {
			if(arr[start]>arr[end]) {
				alice+=arr[start];
				start++;
			}
			else {
				alice+=arr[end];
				end--;
			}
			if(arr[start]>arr[end]) {
				bob+=arr[start];
				start++;
			}
			else {
				bob+=arr[end];
				end--;
			}
		}
		System.out.println("alice : " + alice + " bob : "+bob);
	}




	public static void bySum(int[] arr) {
		int alice=0;
		int bob=0;
		int sumz=0;
		int sume=0;
		int start=0;
		int end=arr.length-1;
		for(int i=0;i<arr.length-1;i+=2) {
			sumz+=arr[i];
		}
		for(int j=1;j<arr.length-1;j+=2) {
			sume+=arr[j];
		}

		while (start<end) {
			if(sumz>sume) {
				if(start%2==0) {
					alice+=arr[start];
					start++;
				}
				else {
					alice+=arr[end];
					end--;
				}
				if(arr[start]>arr[end]) {
					bob+=arr[start];
					start++;
				}
				else {
					bob+=arr[end];
					end--;
				}
			}
			else {
				if(end%2!=0) {

					alice+=arr[end];
					end--;
				}
				else {
					alice+=arr[start];
					start++;
				}
				if(arr[start]>arr[end]) {
					bob+=arr[start];
					start++;
				}
				else {
					bob+=arr[end];
					end--;
				}
			}
		}
		System.out.println("alice : " + alice + " bob : "+bob);
	}




}




