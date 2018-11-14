
public class Ex1 {

	public static int FreqX(int[][] mat, int x) {
		int count =0;//int for counting how much times x appears
		int line =mat.length-1;//int for help me search for x its will be present the lines
		int col =0;//int for help me search for  x its will be present the columns
		while(col<mat.length && line>-1) {//in this while i will look for x 
			if(mat[col][line]==x) {//if the number in the matrix place is x we will count it and go up the lines and right at the columns
				count++;
				col++;
				line--;
			}
			else if(mat[col][line]>x) {//if the number at the matrix is bigger then x will go up the lines
				line--;
			}
			else if(mat[col][line]<x) {//if the number is little then x we go right at the columns
				col++;
			}
		}
		return count;
	}

	public static int NumOfTriplets(int[] mat, int x) {
		int hsort= 0;//int for helping me sort the matrix
		for(int i=0 ; i<mat.length-1 ; i++) {//2 fors that doing bubble sort to the matrix
			for(int j=i+1; j<mat.length ;j++) {
				if(mat[j]<mat[i]) {
					hsort=mat[i];
					mat[i]=mat[j];
					mat[j]=hsort;
				}
			}
		}

		int count =0;//int that will help me count the triples
		for(int i=0 ; i<mat.length-1 ; i++) {//for for chosing one number to check if any two other number with him can be equal x
			int j=i+1;
			int y=mat.length-1;
			while(j!=y || j<y ) {//in this while we will move j and y according to some ifs
				if(mat[j]+mat[y]==x-mat[i]) {//if the two number with i equal x we do count++ and move j right
					count++;
					j++;
				}
				else if(mat[j]+mat[y]<x-mat[i]) {//if the two numbers with the number in the i place little then x we move j right so the number at j will be bigger
					j++;
				}
				else if(mat[j]+mat[y]>x-mat[i]) {//if the two numbers with the number in the i place are bigger the x we move y left so the number at y will be smaller
					y--;
				}
			}
		}
		return count;
	}

}