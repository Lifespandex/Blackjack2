package blackjack2;

import java.util.ArrayList;
import java.util.Collections;

public class Deck {
	public static ArrayList<Card> deck;
	
	public Deck()
	{
		resetDeck();
	}
	
	//52 new cards.
	public void resetDeck()
	{
		deck = new ArrayList<Card>();

		for(int b = 1; b <= 4; b++)
			for(int a = 1; a <= 13; a++)
				deck.add(new Card(a, b));
	}
	
	//removes the top card from the deck and returns it.
	public static Card deal()
	{	
		if(!isEmpty()) //if the deck isn't empty...
			return deck.remove(0);
			
		return null;
	}
	
	public static boolean isEmpty()
	{
		return !(deck.size() > 0);
	}
	
	public void shuffle()
	{
		//write this method to shuffle the deck.
		Collections.shuffle(deck);
	}
	 
	public String toString()
	{
		String s = "Deck Contents:\n";
		
		for(Card c : deck)
			s += "\t" + c.trueValue + "\n";
		
		return s;
	}
	
	int deckSize() {
		return deck.size();
	}
}