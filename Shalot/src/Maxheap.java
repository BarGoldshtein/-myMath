
public class Maxheap {
	int[ ]array;
	int size;
	int captivity;
	int head;
	public Maxheap(int n) {
		captivity=n;
		size=0;
		head=0;
		array=new int[n];
	}
	public int getsize() {
		return size;
	}
	public static int getparent(int n) {
		return (n-1)/2;
		
	}
	public static int getleft(int n) {
		return (n+1)*2;
	}
	public static int getright(int n) {
		return(n+2)*2;
	}
	
	public void removebig() {
		size--;
		array[0]=array[size];
	}
	
	public boolean add(int n) {
		boolean flag=false;
		if(captivity==size) {
			
		}
		else if(size==0) {
			array[size]=n;
			size++;
			flag=true;
		}
		else {
			array[size]=n;
			size++;
			flag=true;
		}
		return flag;
	}
	public void removebig(int x) {
		int test=0;
		while(test<size) {
			if(x<array[0]) {
				removebig();
			}
		}
	}
	public void print_big(int x,int head) {
		if(head>=size) {
			return;
		}
		if(array[head]>x) {
			System.out.println(array[head]);
			print_big(x,getleft(head));
			print_big(x,getright(head));
		}
	}
	
	
	
	public  boolean binaryserch(int x) {
		return binearyserch(root ,x);
	
	}
	
	public static boolean binaryserch(Node root,int x) {
		if(root==null) {
			return false;	
		}
		if (root.data==x) {
			return true;
		}
		if(root<x) {
			return binarysech(root.left,x);
		
		}
		else {
			return binaryserch(root.right,x);
			
		}
		
	}
	
	
	
	
	
	
	
	
}
