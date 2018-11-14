package htest;

public class AccountContainer {
	private BankAccount [] accounts ;
	private int size;
	private static final int init_size =5;
	
	public AccountContainer() {
		this.accounts=new BankAccount[init_size];
		this.size=0;
		
	}
	
	public AccountContainer(AccountContainer other) {
		this.accounts=new BankAccount[other.accounts.length];
		for(int i=0;i<other.size;i++) {
			this.accounts[i]= new BankAccount (other.accounts[i]);
		}
		this.size=other.size;
			
		}
	
	public void resize () {
		BankAccount [] temp =new BankAccount [this.size+init_size];
		for (int i=0;i<this.size;i++) {
			temp[i]=this.accounts[i];
		}
		this.accounts=temp;
	}
	
	public void addElement(BankAccount other) {
		if(this.size==this.accounts.length) {
			resize();
		}
			else {
				this.accounts[this.size]=new BankAccount(other);
		this.size++;
		
			}
		}
	
	public int getsize() {
		return this.size;
	}
	public boolean isOverdraft(int id) {
		for(int i=0;i<accounts.length;i++) {
			if(accounts[i].getid()==id) {
				if(accounts[i].overdraft()) {
					return true;
				}
				else {
					return false;
				}
			}
		}
		return false;
	}
	
	public void delete() {
		for(int i=0;i<this.size;i++) {
			if(this.accounts[i].getbalance()==0) {
				this.accounts[i]=this.accounts[this.size-1];
				this.size--;
				i--;
			}
		}
	}
	
	public String toString() {
		for(int i=0;i<this.size;i++) {
			this.accounts[i].tostring();
		}
		return null;
		
	}
	}
	
	


