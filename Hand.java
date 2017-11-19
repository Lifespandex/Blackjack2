package blackjack2;


import java.util.ArrayList;
 
public class Hand {
	public static ArrayList<Card> yourHand;
	public static ArrayList<Card> dealerHand;
	
	public void resetHand() {
		yourHand = new ArrayList<Card>();
	}
	
	/*
	public void hit() { 
		yourHand.add(Deck.deal());
	}
	*/

}
