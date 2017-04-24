package blackjack.model;

import java.util.ArrayList;

public class Dealer extends Player {
    private Deck deck;
    private ArrayList<Card> hand;
    
    public Dealer() {
        deck = new Deck();
    }
    
    public Card deal() {
        return deck.deal();
    }
    
    public void shuffleDeck() {
        deck.shuffle();
    }
    
    /*
     * Used to start the playHandPhase of a turn by dealing 
     * a hand to the Player first, then to this Dealer itself.
     */
    public void dealStartingHands(Player player) {
        player.acceptDealtCard(deal());
        player.acceptDealtCard(deal());
        
        this.acceptDealtCard(deal());
        this.acceptDealtCard(deal());
    }
    
    /*
     * Note: We could have Player.requestDeal() simply
     * force the dealer to deal a card. But it seems
     * more true-to-life that Players only request
     * a deal, then dealers respond to that request in
     * some way (here, by dealing a card!).
     * 
     * (There could, in theory, be future cases where we 
     * wouldn't want the dealer to give them a card.
     * Keeping this method makes our code "open for extension."
     */
    public void processDealRequest(Player player) {
        player.acceptDealtCard(deal());
    }
    
    public boolean mustHit() {
        return getHandTotal() < 17;
    }

    @Override
    public void split(Dealer dealer) {
        //Do nothing because we aren't implementing Dealer splitting yet
    }

    @Override
    public void printSplitHand() {
        //Do nothing because we aren't implementing Dealer splitting yet
    }
    
    
    //Implementation of Dealer continued here
}
