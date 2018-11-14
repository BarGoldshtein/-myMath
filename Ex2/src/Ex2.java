
public class Ex2 {

	public static void sort(int [] a) {
		int [][] arr= new int [2][a.length];//open a matrix to count k(we use int help to count for us how much different numbers there is)
		int help=1;//this integer will help house count how much different numbers there is
		for (int i =0 ; i<a.length ; i++) {//we use this for and the next for (look the second for run at max o(help) times
			for(int j=0 ;j<help ; j++) {
				if(j==0 && i==0) {//if its the first run of the fors fill the first place in in arr with the first int in "a" and count it
					arr[0][0]= a[0];
					arr[1][0]=1;

				}
				else if(arr[0][i]==a[j]) {//if there is anther number fill it in the matrix
					arr[1][i]++;
					break;
				}
				else if (help-1 == j) {//if in the last for we didnt found any other number like it will fill the next number and count it and help is +1
					arr[0][help-1]=a[help-1];
					arr[1][help-1]=1;
					help++;
					break;
				}
				if(help==a.length-1) {//fill the last int in "a" at arr
					arr[0][a.length-1]= a[a.length-1];
				}
			}
		}
		for(int i=0;i<help;i++) {//this two fors will sort the matrix still j and i is at max help
			for (int j=0 ; j<help-i-1;j++) {
				if(arr[0][j]>arr[0][j+1]) {
					int temp=arr[0][j];
					arr [0][j]=arr[0][j+1];
					arr [0][j+1]=temp;

				}

			}

		}
		int count =0;//help us fill a with the arr after it sorted
		for (int i=0 ; i<a.length;i++) {
			a[count++]=arr[0][i];
		}

	}

}

