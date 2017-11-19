package blackjack2;

public class Card {
	private int value, suit;
	private String cardName;
	private String cardTile;
	private String suitValue;
	
	public Card(int value, int suit)
	{
		this.value = value;
		this.suit = suit;
		
		cardName = genCardName(value, suit);
	}
	
	
	
	//v = (1, 13), s = (1,4)
	private String genCardName(int v, int s)
	{
		String cardValue;
		
		switch(v)
		{
			case 1: cardValue = "A"; break;
			case 11: cardValue = "J"; break;
			case 12: cardValue = "Q"; break;
			case 13: cardValue = "K"; break;
			default: cardValue = "" + v; break;
		}
		
		
		switch(s)
		{
			case 1: suitValue = "♠"; break;
			case 2: suitValue = "♥"; break;
			case 3: suitValue = "♣"; break;
			case 4: suitValue = "♦"; break;
		}
		
		
		cardTile = "[" + cardValue + "" /* + suitValue */  + "]";
		
		//return cardValue;
		return cardTile;
	}
	
	//gets card value
	public int getVal()
	{
		return value;
	}
	
	//sets card value. useful if you wanna reassign values
	//example: King in blackjack actually = 10.
	public void setVal(int val)
	{
		this.value = val;
	}
	
	public String toString()
	{
		return cardName;
	}
}