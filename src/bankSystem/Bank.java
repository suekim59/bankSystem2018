package bankSystem;

public class Bank extends BankInfo implements InterBank {
	
	private int balance;
	
	public Bank() {
		super();
	}
	
	public Bank(int balance) {
		super();
		this.balance = balance;
	}
	
	public int getBalance() {
		return balance;
	}

	public void setBalance(int balance) {
		this.balance = balance;
	}
	
	public String show() {
		super.show();
		return super.show()+"Balance : "+this.getBalance()+"\n";
	}

	public Bank(String userId, String pass, int age, int balance) {
		super();
		super.setUserId(userId);
		super.setPass(pass);
		super.setAge(age);
		//this.balance=(double) balance;
		this.balance= balance;
		
	}


	@Override
	public String toString() {
		return "Bank [balance=" + balance + ", getPass()=" + getPass() + ", toString()=" + super.toString()
				+ ", getUserId()=" + getUserId() + ", getAge()=" + getAge() + ", getClass()=" + getClass()
				+ ", hashCode()=" + hashCode() + "]";
	}

	@Override
	public void deposit(int balance) {
		this.balance+=balance;
		
	}

	@Override
	public void withdraw(int balance) {
		this.balance-=balance;
		
	}

	
}
