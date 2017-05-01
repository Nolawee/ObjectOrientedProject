package blackjack.model;

public class Card {
	private int number;
	private String suit;
	private boolean isFaceUp = false;
	
	public final static int JACK = 11;
	public final static int QUEEN = 12;
	public final static int KING = 13;
	public final static int ACE = 1;
	
	public final static String DIAMONDS = "diamond";
	public final static String CLUBS = "club";
	public final static String HEARTS = "heart";
	public final static String SPADES = "spade";
	
	public final static String BLACK = "black";
	public final static String RED = "red";
			
	
	public Card(int num, String suit) throws Exception {
		if (isProperNumber(num)) number = num;
		else throw new Exception("Invalid number: " + num + ". Card number must be between 1 and 13 (Between ACE-KING)");
		
		if (isProperSuit(suit)) this.suit = suit;
		else throw new Exception("Invalid suit: " + suit + ". Card suit must be either 'DIAMONDS', 'CLUBS', 'HEARTS', or 'SPADES'.");
	}
	
	public void reveal() {
		isFaceUp = true;
	}
	
	public boolean isFaceUp() {
		return isFaceUp;
	}
	
	public int getNumber() {
	    switch (number) {
	        case JACK: return 10;
	        case QUEEN: return 10;
	        case KING: return 10;
	        default: return number;
	    }
	}
	
	public String getValue() {
	    switch (number) {
	        case ACE: return "Ace"; 
	        case JACK: return "Jack";
	        case QUEEN: return "Queen";
	        case KING: return "King";
	        default: return "" + number;   
	    }
	}
	
	public String getSuit() {
		return suit;
	}
	
	public String getColor() {
		switch (suit) {
			case DIAMONDS: return RED;
			case CLUBS: return BLACK; 
			case HEARTS: return RED;
			default: return BLACK; //SPADES (Java complains without a default case).
		}
	}
	

	//----Helper methods-----------------------------------------------------------------------------------------------------------
	
	private boolean isProperNumber(int num) {
		if (num >= 1 && num <= 13) return true;
		else return false;
	}
	
	private boolean isProperSuit(String suit) {
		if (suit.equals(DIAMONDS) || suit.equals(CLUBS) || suit.equals(HEARTS) || suit.equals(SPADES))
			return true;
		else
			return false;
	}
}
