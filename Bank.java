package blackjack2;

public class Bank {
	static int balance;
	static int pot;
	
	
	public static void resetBalance() {
		balance = 5;
	}
	
	//Placing a bet
	public static void bet(int amount) {
		pot += amount;
		balance -= amount;
	}
	
	//Adjusting Balance and Pot after round
	public static void win() {
		if (Driver.finishedRound == false) {
			System.out.println("\nYou win!");
			balance += 2 * pot;
			pot = 0;
			DealerHand.printHandNoCover();
			Driver.finishedRound = true;
		}
	}
	
	public static void tie() {
		if (Driver.finishedRound == false) {
			System.out.println("\nYou tied.");
			balance += pot;
			pot = 0;
			DealerHand.printHandNoCover();
			Driver.finishedRound = true;
		}
	}
	
	public static void lose() {
		if (Driver.finishedRound == false) {
			System.out.println("\nYou lose.");
			pot = 0;
			DealerHand.printHandNoCover();
			Driver.finishedRound = true;
		}
	}
	
}

