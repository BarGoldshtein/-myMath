package htest;

public class BankAccount {
	private String name;
	private int id;
	private double balance;
	
	public BankAccount(String name ,int id) {
		this.name=name;
		this.id=id;
		balance=0;
	}
	
	public BankAccount(BankAccount b) {
		this.name=b.name;
		this.id=b.id;
		this.balance=b.balance;
	
	}
	
	public void deposit(double number) {
		this.balance=balance+number;
		
	}
	public void withdraw(double number) {
		this.balance=balance-number;
	}
	
	public boolean overdraft() {
		boolean overdraft=false;
		if(this.balance<0) {
			overdraft=true;
		}
		return overdraft;
	}
	
	public String getname() {
		return this.name;
		
		
	}
	
	public String setname(String name) {
		return this.name=name;
	}
	
	public int getid() {
		return this.id;
		
	}
	public double getbalance() {
		return this.balance;
	}
	
	public void tostring() {
		System.out.println("name: " +name+ " id: " + id + " balance: " + balance);
	}

}
