package blackjack.model;

import java.util.ArrayList;

public class HumanPlayer extends Player {
    private ArrayList<Card> splitHand; //only used after choosing to "split"
    
    public HumanPlayer(String name, int startingMoney) {
        setName(name);
        turnsWon = 0;
        this.chips = new Chips(startingMoney);
        isPlaying = false;
    }

    public int getSplitHandTotal() {
        int l = splitHand.size();
        int sum = 0;
        for(int i=0; i < l; i++) {
            sum += splitHand.get(i).getNumber();
        }
        return sum;
    }

    public boolean hasBustedSplit() {
        return getSplitHandTotal() > 21;
    }
    
    /*
     * Called from TurnManager's PlayHandPhase.
     * Splits the player's hand so that they end up
     * with two separate hands of 2 cards each. 
     */
    @Override
    public void split(Dealer dealer) {
        Card splitCard = getHand().get(1); //This will always be called after first deal, so this is their second of 2 cards
        
        splitHand.add(splitCard);
        getHand().remove(splitCard);
        
        hit(dealer); //Dealer deals a second card to the original hand
        splitHand.add(dealer.deal()); //Dealer deals a second card to the new split hand 
    }

    
    
    //Implementation of HumanPlayer continued here
    
    //----Helper methods-----------------------------------------------------------------
    
    @Override
    public void printSplitHand() {
        String printedHand = "SPLIT HAND: [ ";
        
        for (Card card : splitHand) {
            printedHand +=  "" + card.getNumber() + ", "; 
        }
        printedHand.substring(0, printedHand.length()-2); //Trims the comma from the last card's number
        printedHand += " ]";
        
        System.out.println(printedHand);
    }
}
