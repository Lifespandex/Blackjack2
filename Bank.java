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
		System.out.println("You win!");
		balance += 2 * pot;
		pot = 0;
		System.out.println("You now have " + balance + " chips.");
	}
	
	public static void tie() {
		System.out.println("You tied.");
		balance += pot;
		pot = 0;
	}
	
	public static void lose() {
		System.out.println("You lose.");
		pot = 0;
	}
	
}

