package blackjack.model;

public class Deck {
	private Card[] cards;
	private int cardsUsed;
	
	/*
	 * Instantiates a standard deck of cards with
	 * 52 cards and 13 cards for each of the 4 suits
	 * (Diamonds, Clubs, Hearts, and Spades).
	 */
	public Deck() {
		cards = createStandardDeck();
		cardsUsed = 0;
	}
	
	public Deck(Card[] cardsArray) {
		cards = cardsArray;
		cardsUsed = 0;
	}
	
	public void shuffle() {
        for (int i = cards.length-1; i > 0; i--) {
            int rand = (int)(Math.random()*(i+1));
            Card temp = cards[i];
            cards[i] = cards[rand];
            cards[rand] = temp;
        }
        cardsUsed = 0; //Note: this is equivalent to "putting back" all previously dealt cards. 
    }
	
	public boolean isEmpty() {
		if (cardsUsed==cards.length) return true;
		else return false;
	}
	
	public Card deal() {
		if (isEmpty()) throw new IllegalStateException("No cards are left in the deck.");
        cardsUsed++;
        return cards[cardsUsed - 1]; //Note: Cards are not literally removed from 
        							 //the array that represents the deck.  
        							 //We just keep track of how many cards have been used.
	}
	
	
	//----Helper methods---------------------------------------------------
	
	private Card[] createStandardDeck() {
		Card[] newCards = new Card[52];
		String suit = Card.DIAMONDS;
		int i = 0;
		
		try {
			//Add all Diamond cards
			for (int j = 1; j <= 13; j++) {
				newCards[i] = new Card(j, suit);
				i++;
			}
			//Add all Club cards
			suit = Card.CLUBS;
			for (int j = 1; j <= 13; j++) {
				newCards[i] = new Card(j, suit);
				i++;
			}
			//Add all Heart cards
			suit = Card.HEARTS;
			for (int j = 1; j <= 13; j++) {
				newCards[i] = new Card(j, suit);
				i++;
			}
			//Add all Spade cards
			suit = Card.SPADES;
			for (int j = 1; j <= 13; j++) {
				newCards[i] = new Card(j, suit);
				i++;
			}
		} 
		catch (Exception e) {
			System.out.println("Oops! You can't make a Card that way: " + e.getMessage());
			System.out.println("An empty Deck was just returned.");
		}
		
		return newCards;
	}
	
	private void printDeck() {
		for (Card card: cards) {
			System.out.println("Number: " + card.getNumber() + ", Suit: " + card.getSuit());
		}
	}
	
//	public static void main(String[] args) {
//		Deck d = new Deck();
//		d.shuffle();
//		d.printDeck();
//		
//		Card dealt = d.deal();
//		System.out.println("First dealt card: [Card: Number=" + dealt.getNumber() + ", Suit=" + dealt.getSuit() + "]");
//	}
}
