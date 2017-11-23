package blackjack2;


import java.util.ArrayList;
 
public class DealerHand {
	private static ArrayList<Card> hand = new ArrayList<Card>();
	private static String firstCardName;
	
	public static void resetHand() {
		hand = new ArrayList<Card>();
	}
	
	public static ArrayList<Card> getHand() {
		return hand;
	}
	
	//Prints the hand, without unneeded stuff
	public static void printHand() {
		System.out.print("Dealers Hand:\t");
		
		for(int i = 0; i < hand.size(); i++)   {
			System.out.print((hand.get(i).cardName));
		}
		System.out.print("\n");
	}
	
	public static void printHandNoCover() { // Prints dealers hand, without covering the first card with X. Only use at end
		
		hand.get(0).cardName = firstCardName;
		System.out.print("Dealers Hand:\t");
		
		for(int i = 0; i < hand.size(); i++)   {
			System.out.print((hand.get(i)));
		}
		System.out.print("\n");
	}
	
	
	//Deals first 2 cards
	public static void firstDeal() {
		
			Card c = Deck.deal();
			firstCardName = c.cardName;
			c.cardName = "[X]";
			hand.add(c);
			c = Deck.deal();
			hand.add(c);
			printHand();
	}

	public static void hitMe() { 
		Card c = Deck.deal();
		//System.out.println(c.toString());
		hand.add(c);
		printHand();
		
	}
	
	public static int handValue() {
		int dealerScore = 0;
		for(int m = 0; m < getHand().size(); m++) { // Checks for 21
			dealerScore += getHand().get(m).trueValue;
		}
		return dealerScore;
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
