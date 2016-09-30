public class Account {

	private int accountNumber;
	private double balance;

	Account() {
		balance = 0.0;
	}

	Account(int accNum, double bal) {
		this.accountNumber = accNum;
		this.balance = bal;
	}

	Account(int accNum) {
		this.accountNumber = accNum;
	}

	int getAccountNumber() {
		return accountNumber;
	}

	double getBalance() {
		return balance;
	}
	
	void setBalance(double bal) {
		balance = bal;
	}

	void credit(double amount) {
		if(amount > 0) {
			balance = balance + amount;
		}
	}

	void debit(double amount) {
		if(balance >= amount) {
			balance = balance - amount;
		} else {
			System.out.println("Amount withdrawn exceeds the current balance!");
		}
	}

	public String toString() {
		return String.format("Account Number : %d, Balance = $%.2f", accountNumber, balance);
	}

}
