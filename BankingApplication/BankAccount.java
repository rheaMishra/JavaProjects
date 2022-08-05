package bankAccount.application;
import java.util.Scanner;
public class BankAccount {
	int balance;
	int previousTransaction;
	String customerName;
	String customerId;
	public BankAccount(String customerName, String customerId) {
		this.customerName = customerName;
		this.customerId = customerId;
	}
	public void deposit(int amount) {
		if(amount!=0) {
			balance += amount;
			previousTransaction = amount;
		}
	}
	public void withdraw(int amount) {
		if(amount!=0) {
			balance -= amount;
			previousTransaction = -amount;
		}
	}
	public void getPreviousTransaction() {
		if(previousTransaction > 0) {
			System.out.println("Deposited: "+previousTransaction);
		}else if(previousTransaction < 0) {
			//Math.abs will remove - sign 
			System.out.println("Withdrwan: "+ Math.abs(previousTransaction));
		}else {
			System.out.println("No transaction occured");
		}
	}
	public void showMenu() {
		char option ;
		Scanner s = new Scanner(System.in);
		System.out.println("Welcone "+ customerName);
		System.out.println("Enter Your CustomerID "+ customerId);
		System.out.println();
		System.out.println("A. Check Balance");
		System.out.println("B. Deposit");
		System.out.println("C. Withdraw");
		System.out.println("D. Previous transaction");
		System.out.println("E. Exit");
		do {
			System.out.println("======================================================================");
			System.out.println("Enter an option");
			System.out.println("======================================================================");
			option = s.next().charAt(0);
			System.out.println();
			switch(option){
			case 'A':
				System.out.println("------------------------------------------------------------------");
				System.out.println("Current Balance "+balance);
				System.out.println("------------------------------------------------------------------");
				System.out.println();
				break;

			case 'B':
				System.out.println("------------------------------------------------------------------");
				System.out.println("Enter an amount to deposit: ");
				System.out.println("------------------------------------------------------------------");
				int depositAmount = s.nextInt();
				deposit(depositAmount);
				System.out.println();
				break;

			case 'C':
				System.out.println("------------------------------------------------------------------");
				System.out.println("Enter an amount to withdraw: ");
				System.out.println("------------------------------------------------------------------");
				int withdrawAmount = s.nextInt();
				deposit(withdrawAmount);
				System.out.println();
				break;

			case 'D':

				System.out.println("------------------------------------------------------------------");
				getPreviousTransaction();
				System.out.println("------------------------------------------------------------------");
				System.out.println();
				break;

			case 'E':
				System.out.println("***************************Exiting********************************");
				break;
			default:
				System.out.println("Inavlid Option!!. Please enter again");
				break;
			}
		}while(option!='E');
		System.out.println("Thankyou for using our services");

	}
}
