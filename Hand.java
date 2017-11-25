package blackjack2;


import java.util.ArrayList;
 
public class Hand {
	private static ArrayList<Card> hand = new ArrayList<Card>();
	
	public static void resetHand() {
		hand = new ArrayList<Card>();
	}
	
	public static ArrayList<Card> getHand() {
		return hand;
	}
	
	//Prints the hand, without unneeded stuff
	public static void printHand() {
		System.out.print("Your Hand:\t");
		
		for(int i = 0; i < hand.size(); i++)   {
			System.out.print((hand.get(i).cardName));
		}
		System.out.print("\n");
	}
	
	// Deals first 2 cards
	public static void firstDeal() {
			
			Card c = Deck.deal();
			hand.add(c);
			
			c = Deck.deal();
			hand.add(c);
			
			printHand();
	}

	public static void hitMe() { 
		Card c = Deck.deal();
		System.out.println("\nYou drew: " + c.toString() + "\n");
		hand.add(c);
		
		printHand();
	}
	
	public static int handValue() {
		int yourScore = 0;
		for(int m = 0; m < getHand().size(); m++) { // Checks for 21
			yourScore += getHand().get(m).trueValue();
		}
		return yourScore;
	}
	
	public static void aceSwap() {
		for (int i = 0; i < getHand().size(); i++) {
			
			if (getHand().get(i).trueValue() == 11) {
				getHand().get(i).trueValue = 1;
				break;
			}
			
		}
	}
}
