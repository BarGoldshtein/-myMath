
public class recorsia {
	public static int sum (int a , int b) {
	if(a+b==a) {
		return a;
	}
	else {
		return sum(a,(b-1))+1;
	}
	}
	
	public static int substruct(int a, int b) {
		if(a-b==a) {
			return a;
			
		}
		else {
			return substruct(a, (b-1))-1;
		}
		
	}
	
	public static int multiply(int a, int b) {
		if(a*b==a) {
			return a;
					
		}
		else {
			return multiply(a ,(b-1))+a;
		}
	}
	
	public static int division(int a, int b) {
		if(a/b==a) {
			return a;
			
		}
		else {
			return division(a-b, b)+1;
			}
		}
	
	public static int remainder(int a, int b) {
		if(a%b==a){
			return a;
		
		}
		else {
			return remainder(a-b ,b);
		}
	}
	
	public static int power (int n) {
		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
	System.out.println("sum:"+ sum(5,3));
	System.out.println("sub:"+ substruct(5,3));
	System.out.println("div:"+ division(12, 3));
	System.out.println("mul:"+ multiply(4, 3));
	System.out.println("re:"+ remainder(8, 2));
	}

}
