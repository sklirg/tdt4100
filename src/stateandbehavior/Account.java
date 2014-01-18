package stateandbehavior;

public class Account {
	double balance;
	double interestRate;
	
	public Account() {
		this.balance = 0;
		this.interestRate = 5;
	}
	
	public boolean deposit(double amount) {
		if (amount < 0) {
			return false;
		}
		else {
			this.balance += amount;
			return true;
		}
	}
	
	public void addInterest() {
		this.balance += this.balance * (this.interestRate/100);  
	}
	
	public String toString() {
		return "Balance=" + this.balance + ", interest="+this.interestRate;
	}
	
	public static void main(String[] args) {
		Account a = new Account();
		a.deposit(100);
		System.out.println(a);
		a.addInterest();
		System.out.println(a);
	}
	
	
}
