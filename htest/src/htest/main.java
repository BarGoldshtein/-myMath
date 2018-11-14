package htest;

public class main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		BankAccount barb =new BankAccount("bar" , 1234);
		barb.tostring();
		barb.deposit(500);
		barb.tostring();
		barb.withdraw(200);
		barb.tostring();
		
		BankAccount haib= new BankAccount(barb);
		haib.tostring();
		
		System.out.println(barb.overdraft());
		System.out.println(barb.getname());
		System.out.println(barb.getbalance());
		System.out.println(barb.getid());
		haib.setname("Hai");
		haib.tostring();
		System.out.println();
		
		AccountContainer b=new AccountContainer();
		b.addElement(barb);
		b.toString();
		b.addElement(haib);
		b.toString();
	
String s="ba bbaa beab bebebe";
String [] s2=s.split(" ");
int max =0;
 for(int i=0;i<s2.length;i++) {
	 if(s2[i].length()>max) {
		 max=s2[i].length();
	 }
 }
 for (int i=0;i<s2.length;i++) {
	 if(s2[i].length()==max) {
		 System.out.println(s2[i]);
		 break;
	 }
 }
 
 
 
 int [] arr= {1,2,2,1};
 boolean sort=true;
 for(int i=0;i<arr.length/2;i++) {
	 for(int j=arr.length-1;j>i;j--) {
		 if(arr[i]!=arr[j]) {
			 sort=false;
			 
		 }
		 i++;
	 }
	 
 }
 System.out.println(sort);
 }
}
