
public class StackPlusMax {
	int size;
	int captivity;
	int max;
	int []stack;
	int[]stackmax;
	int sizemax;

	public StackPlusMax (Integer size) {
		captivity=size;
		stack=new int[captivity];
		this.size=0;
		stackmax=new int[captivity];
	}
	
	public void push(Integer val) {
		if(size<captivity) {
			stack[size]=val;
			size++;
		
		if(stackmax[sizemax]<=val) {
			sizemax++;
			stackmax[sizemax]=val;
			
		}
		}
	}
	
	public Integer pop() {
		if(size!=0) {
			size--;
			if(stackmax[sizemax]==stack[size]) {
				sizemax--;
			}
			return stack[size];
		}
		else {
			return Integer.MAX_VALUE;
		}
		
	}
	
	public Integer max() {
		return stackmax[sizemax];
	}
	
	public String toString() {
		String stackk="";
		for(int i=0;i<=size-1;i++) {
			stackk=stackk+ stack[i]+",";
		}
		return stackk;
	}
	
	public static void main(String[] args) {
		StackPlusMax st = new StackPlusMax(10);  	 	
		int[] b = {3,2,5,8,7,5,7,8,4,9 };  
 	 	for (int i=0; i<b.length; i++) {
 	 		st.push(b[i]);
 	 		} 
 	 	System.out.println(st); 
 	 	System.out.println("   max = "+st.max()); 
 	 	System.out.println("pop = "+st.pop()); 
 	 	System.out.println("pop = "+st.pop()); 
 	 	System.out.println("pop = "+st.pop()); 
 	 	System.out.println("pop = "+st.pop()); 
 	 	System.out.println(st); 
 	 	System.out.println("   max = "+st.max()); 
 	 	System.out.println("pop = "+st.pop()); 
 	 	System.out.println("pop = "+st.pop()); 
 	 	System.out.println("pop = "+st.pop()); 
 	 	System.out.println("pop = "+st.pop()); 
 	 	System.out.println("pop = "+st.pop());
 	 	//System.out.println("st1 = "+st.st1); 
 	 	System.out.println(st); 
 	 	System.out.println("   max = "+st.max());} 


	}

