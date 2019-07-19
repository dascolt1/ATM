import java.util.*;


public class ATM {

	static Scanner scnr = new Scanner(System.in);
	static boolean continues = true;

	public static void main(String[] args) {

		ArrayList<Account> list = new ArrayList<Account>();
			

		menu();
		int input = scnr.nextInt();

		boolean executed = false;

		

		while(continues) {

			if(input == 1) {

				if(executed = true) {
					executed = false;
				}


				if(!executed) {
					System.out.println("Please choose a card number.");
					int cardNumber = scnr.nextInt();

					if(checkCardNumber(cardNumber, list)){
						createAccount(list, cardNumber);
					}else {
						System.out.println("Sorry, card number is already in use, please choose another");
					}


					executed = true;
				}


				menu();
				input = scnr.nextInt();

				

			}else if(input == 2) {

				//makes sure executed reverts back to false
				
					executed = false;
				

				

				//stops function from being called multiple times
				if(!executed){

					System.out.println("Please enter your account number");
					int acctNum = scnr.nextInt();

					System.out.println("Please enter your pin");
					int pin = scnr.nextInt();
				
					if(validAccountNumber(list, acctNum)) {
							verifyAccount(list, acctNum, pin);
							continues = false;
																		
					}else{
						System.out.println("Account number doesn't exist... exiting system");
						continues = false;
					}
					
				}

				
								
			}else if(input == 3) {
				if(executed == true) {
					executed = false;
				}

				if(!executed) {
					System.out.println("Please enter admin password");
					String password = scnr.next();
					adminCheck(list, password);
					executed = true;
				}
				menu();
				input = scnr.nextInt();
			}else if(input == 4) {
				continues = false;
			}
		}


	}


	public static void createAccount(ArrayList<Account> list, int cardNumber) {

		System.out.println("Please enter your first name.");
		String firstName = scnr.next();

		System.out.println("Please enter your last name.");
		String lastName = scnr.next();

		System.out.println("Please enter a secure pin for your account.");
		int pin = scnr.nextInt();

		list.add(new Account(firstName, lastName, pin, cardNumber));

	}

	//verifys if account info is valid then prompts what to do with account
	public static void verifyAccount(ArrayList<Account> list, int cardNumber, int pin) {
		boolean transaction = true;
		boolean executed = false;

			for(int i = 0; i < list.size(); i++){

				if(cardNumber == list.get(i).getCardNumber()) {
					
					if(pin == list.get(i).getPin()){
						System.out.println("Welcome " + list.get(i).getFirstName() + " " + list.get(i).getLastName());
						System.out.println("You have $" + list.get(i).getBalance());

						atmMenu();
						int input = scnr.nextInt();

						while(transaction){
							if(input == 1) {
								System.out.println("Please enter amount to deposit.");
								double moneyToDeposit = scnr.nextDouble();
								list.get(i).deposit(moneyToDeposit);
								System.out.println("You deposited" + "$" + moneyToDeposit);
								atmMenu();
								input = scnr.nextInt();
							}else if(input == 2) {

								System.out.println("Please enter amount to withdraw.");
								double moneyToWithdraw = scnr.nextDouble();
								if(moneyToWithdraw > list.get(i).getBalance()){
									System.out.println("You have insufficient funds.");
									System.out.println("You can only withdraw " + list.get(i).getBalance());
									atmMenu();
									input = scnr.nextInt();
								}else{
									list.get(i).withdraw(moneyToWithdraw);
									System.out.println("You withdrew" + "$" + moneyToWithdraw);
									atmMenu();
									input = scnr.nextInt();
								}

							}else if(input == 3) {

								executed = false;

								if(!executed){
									list.get(i).accountInfo();
								}

								executed = true;

								atmMenu();
								input = scnr.nextInt();
							}else if(input == 4) {
								
								System.out.println("Balance: " + list.get(i).getBalance());

								atmMenu();
								input = scnr.nextInt();

							}else if(input == 5) {
								transaction = false;
							}
						}
						
					}else {
						System.out.println("Wrong pin, system exiting...");
					}
					
				}
			}
	}

	//traverses array and checks to see if person has valid account number
	private static boolean validAccountNumber(ArrayList<Account> list, int cardNumber) {

		for (int i = 0; i < list.size(); i++) {
			if(cardNumber == list.get(i).getCardNumber()) {
				return true;
			}
		}

		return false;
	}

	public static void adminCheck(ArrayList<Account> list, String password) {
		if(password.toLowerCase().equals("root")) {
			if(list.size() > 0){
				for (int i = 0; i < list.size(); i++) {
					System.out.println("Last name: " + list.get(i).getLastName() + " " + "Account number: " + list.get(i).getCardNumber());
				}
			}else {
				System.out.println("No accounts available");
			}
		}
	}

	public static boolean checkCardNumber(int cardNumber, ArrayList<Account> list) {
		for(int i = 0; i < list.size();i++) {
			if(cardNumber == list.get(i).getCardNumber()) {
				return false;
			}
		}

		return true;
	}

	public static void menu() {
		System.out.println("     --------------------------------------");
		System.out.println("                      Menu");
		System.out.println(" Please enter number 1 to create account");
		System.out.println(" Please enter number 2 to login to your account.");
		System.out.println(" Please enter number 3 to view all account numbers (admin only)");
		System.out.println(" Please enter number 4 to quit");
		System.out.println("     --------------------------------------");
	}

	public static void atmMenu() {
		System.out.println("     --------------------------------------");
		System.out.println("                      Account Menu");
		System.out.println(" Please enter number 1 to deposit money");
		System.out.println(" Please enter number 2 to withdraw money");
		System.out.println(" Please enter number 3 to see account info");
		System.out.println(" Please enter number 4 to view current balance");
		System.out.println(" Please enter number 5 to logout");
		System.out.println("     --------------------------------------");
	}
}