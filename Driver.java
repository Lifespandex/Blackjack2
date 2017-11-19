package blackjack2;

public class Driver {
	public static void main(String [] args)
	{
		Deck deck = new Deck();
		
		Bank.resetBalance();
		
		System.out.println("You have " + Bank.balance + " chips.");
		
		deck.shuffle();
		
		Card c = deck.deal();
		
		System.out.println(c);
		
		System.out.println(Hand.yourHand);
		}
}