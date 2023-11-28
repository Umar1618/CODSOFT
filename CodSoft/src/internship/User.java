package internship;

import java.util.Scanner;

//User class
class User {

	public static void main(String[] args) {
		System.out.println("****Welcome****");
		Bank bank = new ATMMachine();
		bank.atm();
		System.out.println("Remove Your Card!!");
	}

}

// Bank class
abstract class Bank{
	
	// we can change the balance here
	double balance = 5000;
	
	// atm() to perform ATM Operations	
	abstract void atm();
	
	abstract void deposit(int amount);
	abstract void withDraw(int amount);
	abstract void checkBalance();
}

// Atm Machine class
class ATMMachine extends Bank{
	
	static Bank atm = new ATMMachine();
	
	@Override
	void atm() {
		Scanner sc = new Scanner(System.in);
		System.out.println("*****Insert Your Card******");
		System.out.println("Enter our pin :");
		int pin =sc.nextInt();

		// we can change the ATM pin here
		if(pin==1234) {
			System.out.println("1.Deposit\n2.Withdraw\n3.checkBalance\n4.Exit");
			int n=sc.nextInt();
			switch (n) {
			case 1:{
				System.out.println("Please enter amount to deposit");
				int amount=sc.nextInt();
				atm.deposit(amount);
				System.out.println("Remove Your Card!!");
				atm();
				break;
			}
			case 2:{
				System.out.println("Please enter amount to withdraw");
				int amount=sc.nextInt();
				atm.withDraw(amount);
				System.out.println("Remove Your Card!!");
				atm();
				break;
			}
			case 3:{
				atm.checkBalance();
				System.out.println("Remove Your Card!!");
				atm();
				break;
			}
			case 4:{
				System.out.println("Thank You!!");
				break;
			}
			default:
				System.out.println("Choose the Correct Choice");
				System.out.println("Remove Your Card And Try Agin!!");
				atm();
				break;
			}
		}
		else {
			System.out.println("Invalid pin");
			System.out.println("Remove Your Card And Try Agin!!");
			atm();
		}
		sc.close();
	}
	
	@Override
	void deposit(int amount) {
		if(amount>0) {
			balance+=amount;
			System.out.println("Deposited Rs."+ amount+" Successfully");
		}
		else
			System.out.println("*****Amount Not Accepted*****");
	}
	
	@Override
	void withDraw(int amount) {
		if(balance>=amount) {
			balance-=amount;
			System.out.println("Withdrawn Rs."+amount+" Successfully");
		}
		else
			System.out.println("******Insufficient balance*******");
	}

	@Override
	void checkBalance() {
		System.out.println("Your Available balance : Rs."+balance);
	}
}
