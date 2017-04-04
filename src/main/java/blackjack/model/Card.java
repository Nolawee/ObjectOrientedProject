package blackjack.model;

public class Card {
	private int number;
	private String suit;
	private boolean isFaceUp = false;
	
	final int JACK = 11;
	final int QUEEN = 12;
	final int KING = 13;
	final int ACE = 1;
	
	final String DIAMONDS = "d";
	final String CLUBS = "c";
	final String HEARTS = "h";
	final String SPADES = "s";
	
	final char BLACK = 'b';
	final char RED = 'r';
			
	
	public Card(int num, String suit) throws Exception {
		if (isProperNumber(num)) number = num;
		else throw new Exception("Card number must be between 1 and 13 (Between ACE-KING)");
		
		if (isProperSuit(suit)) this.suit = suit;
		else throw new Exception("Card suit must be either 'DIAMONDS', 'CLUBS', 'HEARTS', or 'SPADES'.");
	}
	
	public void reveal() {
		isFaceUp = true;
	}
	
	public boolean isFaceUp() {
		return isFaceUp;
	}
	
	public int getNumber() {
		return number;
	}
	
	public String getSuit() {
		return suit;
	}
	
	public char getColor() {
		switch (suit) {
			case DIAMONDS: return RED;
			case CLUBS: return BLACK; 
			case HEARTS: return RED;
			default: return BLACK; //SPADES (Java complains without a default case).
		}
	}
	

	//----Helper methods---------------------------------------------------------------------------------
	
	public boolean isProperNumber(int num) {
		if (num >= 1 && num <= 13) return true;
		else return false;
	}
	
	public boolean isProperSuit(String suit) {
		if (suit.equals(DIAMONDS) || suit.equals(CLUBS) || suit.equals(HEARTS) || suit.equals(SPADES))
			return true;
		else
			return false;
	}
}
