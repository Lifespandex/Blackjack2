package blackjack2;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Driver {
	
	public static boolean finishedRound = false;
	public static boolean outOfCash = false;
	static Deck deck = new Deck();
	
	static void playRound() {
		
		
		Deck deck = new Deck();
		Hand.resetHand();
		DealerHand.resetHand();
		
		boolean betValid = false;
		System.out.println("You have " + Bank.balance + " chips.");
		
		int f; // Input - Amount of chips to bet
		do {
			
			finishedRound = false; // New round, hasn't finished yet.
			System.out.println("\nHow many chips would you like to bet: ");
			Scanner betScan = new Scanner(System.in);
			
			try {
				
				f = betScan.nextInt();
				
				if ((f >= 0) && (f <= Bank.balance)) {
					
					Bank.bet(f);
					betValid = true;
					System.out.println("");
					
				} else {
					
					System.out.println("\nYou can't bet that.");
				}
				
			}		
					
			catch (InputMismatchException e) {
				System.out.println("\nYou can't bet that.");
				
			}
		} while (betValid == false);

		deck.shuffle();
		
		Hand y = new Hand();
		y.firstDeal();
		
		boolean yBlackJack = false;
		if(y.handValue() == 21) {
			System.out.println("Blackjack!");
			yBlackJack = true;
		}
		
		DealerHand d = new DealerHand();
		d.firstDeal();
		
		if(d.handValue() == 21) {
			
			System.out.println("Dealers Blackjack!");
			if (yBlackJack == true) {
				Bank.tie();
			} else {
				Bank.lose();
			}
		} else if (yBlackJack == true) {
			Bank.win();
		}
		
		
		// Asks for hit or stand
		int i = 2;
		boolean valid = false;
		
		// Whether you have stopped hitting yet
		boolean stood = false; 
		
		boolean dBusted = false;
		boolean yBusted = false;
		
		do{
			do {
				System.out.print("\n" + "Do you want to hit [1] or stand [2]: ");
			
				Scanner sc = new Scanner(System.in);
				try {
					i = sc.nextInt();
					if ((i == 1) || (i == 2)) {
						valid = true;
					} else {
						System.out.println("Please enter either 1 for a hit, or 2 to stand.");
					}
				} catch (InputMismatchException e) {
					System.out.println("Please enter either 1 for a hit, or 2 to stand.");
				} 
			
			} while (valid == false);
		
			
			// Hit or stand, depending on input
			if (i == 1) {
				y.hitMe(); 
				d.printHand();
				
				boolean yNoAces = false;
				if (d.handValue() > 21) { // Change ace(s) from 11 to 1, if needed.
					
					int l = 0;
					while ((y.handValue() > 21) && (yNoAces == false)) {
						
						l = 0; // Number of things that aren't aces
						for (int m = 0; m < y.getHand().size(); m++) {
							
							
							if (y.getHand().get(i).trueValue != 11) {
								l++;
								
							} else {
								y.getHand().get(i).trueValue = 1;
								break;
							}
							
						}	
						
						if (l == y.getHand().size()) {
							yNoAces = true;
						}
						
					}
				
				}
				
				if (y.handValue() > 21) { // if bust
					System.out.println("\nYou busted!");
					stood = true;
					yBusted = true;
				}
			} else {
				
				System.out.print("\n");
				y.printHand();// shows current hands
				d.printHand();
				stood = true;

			}
		}while (stood == false);
		
		
		// Starts dealers turn
		
		if (yBusted == false) {
			 System.out.println("\nDealers Turn.");
		} else {
			Bank.lose();
		}
		
		
		if (yBusted == false) { // If you haven't busted.
	 		boolean hasQuit = false;
			d.handValue();
			
			boolean noAces = false;
			do { 
				d.hitMe();
				d.handValue();
				
				if (d.handValue() > 21) { // Change ace(s) from 11 to 1, if needed.
					
					int l = 0;
					while ((d.handValue() > 21) && (noAces == false)) {
						
						l = 0; // Number of things that aren't aces
						for (int m = 0; m < d.getHand().size(); m++) {
							
							
							if (d.getHand().get(i).trueValue != 11) {
								l++;
								
							} else {
								d.getHand().get(i).trueValue = 1;
								break;
							}
							
						}	
						
						if (l == d.getHand().size()) {
							noAces = true;
						}
						
					}
				
				}
				
				if (d.handValue() > 21) {
					
					System.out.println("Dealer Busted");
					if (yBusted == false) {
						Bank.win();
					} else {
						Bank.tie ();
					}
					hasQuit = true;
				}
				
			}while ((d.handValue() <= 17) && (!hasQuit)); // If 17 or over, sits, else hits
			
			finishedRound = true;
		}
		
		if ((d.handValue() > y.handValue()) && (finishedRound == false)) {
			Bank.lose();
		}
		if ((d.handValue() == y.handValue()) && (finishedRound == false)) {
			Bank.tie();
		}
		if ((d.handValue() < y.handValue()) && (finishedRound == false)) {
			Bank.win();
		}
		
		if (Bank.balance == 0) {
			outOfCash = true;
		}
	}
	
	
	public static void main(String [] args)
	{
		
		
		Bank.resetBalance();
		
		do {
			playRound();
		} while (!outOfCash);
		
		System.out.println("\nGame Over!");
	}
}