public class Account {

	private double balance;
	private String firstName;
	private String lastName;
	private double dollars;
	private int pin;
	private int id;
	private int cardNumber = 0;
	private static int count = 0;

	Account() {
		this.balance = 0;

		id = id++;
	}	

	Account(String firstName, String lastName, int pin, int cardNumber) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.pin = pin;
		this.cardNumber = cardNumber;

		id = id++;
	} 

	public void setBalance(double balance) {
		this.balance = balance;
	}

	public double getBalance() {
		return balance;
	}

	public int getCardNumber() {
		return cardNumber;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setDollars(double dollars) {
		this.dollars = dollars;
	}

	public double getDollars() {
		return dollars;
	}

	public void setPin(int pin) {
		this.pin = pin;
	}

	public int getPin() {
		return pin;
	}

	public void withdraw(double dollars) {
		balance =  balance - dollars;
	}

	public void deposit(double dollars) {
		balance =  balance + dollars;
	}

	public int getID() {
		return id;
	}

	public void accountInfo() {
		System.out.println("Name: " + firstName + " " + lastName);
		System.out.println("Card number: " + cardNumber);
		System.out.println("Pin: " + pin);
		System.out.println("Balance: " + balance);
	}
	
}