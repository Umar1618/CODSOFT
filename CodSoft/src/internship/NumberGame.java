package internship;

import java.util.Random;
import java.util.Scanner;


public class NumberGame {
	
	static Scanner sc = new Scanner(System.in);

	static String playerName ;
	static int rounds = 0, score = 0;

	public static void main(String[] args) {
		
		System.out.println("==Game Starts!==\n");
		System.out.print("Please Enter Your Name : ");
		playerName = sc.nextLine();
		play();
		System.out.println("\n*** "+playerName+" you Won "+score+" out of "+rounds+" Rounds ***");
		System.out.println("\n==Game Ends!==");

	}

	static void play() {
		
		rounds++;
		System.out.println("\nRound : "+rounds);
		System.out.println("\nGuess a Number from (1 to 10)");
				
		// To Generate Random number from 1 to n
		Random random = new Random();
		// We can assign the range
		int range =  10;
		int randomNo = random.nextInt(range)+1;
		
		// We can assign Number of Attempt
		int attempt = 3;
		boolean win = false;
		
		while(attempt>0 && win == false){
			
			System.out.print("\nEnter a Number : ");
			int userNo = sc.nextInt();
			sc.nextLine();
			if(userNo<=0 || userNo>range)
				System.out.println(">>Range is (1 to 10)<<");
			else {
				if(randomNo == userNo) {
					System.out.println("### You Won this Round "+playerName+" ###");
					win = true;
					score++;
				}
				else if(randomNo > userNo) {
					System.out.println(">>Too Low<<");
				}
				else if(randomNo < userNo) {
					System.out.println(">>Too High<<");
				}
				attempt--;
				
				if(attempt>0 && win == false)
					System.out.println("You have " + attempt + " Attempts Left");
				else if(win == false)
					System.out.println("\n### Sorry "+playerName+" You Lost this Round ###");
			}
		}
		
		System.out.print("\nYou Wanna Play again "+playerName+" ? y/n : ");
		String again = sc.nextLine();
		
		if(again.equals("y"))
			play();
		
	}
}
