package blackjack2;

import java.util.ArrayList;
import java.util.Random;

public class Deck {
	private ArrayList<Card> deck;
	
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
	public Card deal()
	{	
		if(!isEmpty()) //if the deck isn't empty...
			return deck.remove(0);
			
		return null;
	}
	
	public boolean isEmpty()
	{
		return !(deck.size() > 0);
	}
	
	public void shuffle()
	{
		//write this method to shuffle the deck.
		
		Random random = new Random();
		ArrayList<Card> tempDeck = new ArrayList<Card>();
		for (int i = 0; i < deck.size(); i++) {
			
			int index = random.nextInt(deckSize());
			tempDeck.add(deck.get(index));
			deck.remove(index);
		}
		
		deck = tempDeck;
	}
	 
	public String toString()
	{
		String s = "Deck Contents:\n";
		
		for(Card c : deck)
			s += "\t" + c + "\n";
		
		return s;
	}
	
	int deckSize() {
		return deck.size();
	}
}