package blackjack.model;

import java.util.ArrayList;

public class ComputerPlayer extends Player {
    Chips currentBet; //We'll be representing bets with chips themselves, not an int.
    Chips chips;

    
    public ComputerPlayer(String name, int startingMoney) {
        setName(name);
        turnsWon = 0;
        chips = new Chips(startingMoney);
        hand = new ArrayList<Card>();
        currentBet = new Chips(0);
        turnsWon = 0;
        isPlaying = false;
    }
    
    /*
     * Note: This is where we get to decide how risky
     * computer players are. 17 is the same as the
     * "mustHit" threshold for Dealer.
     */
    public boolean mustHit() {
        return getHandTotal() < 17;
    }

    @Override
    public void split(Dealer dealer) {
        //Do nothing because we aren't implementing Computer splitting yet
    }

    @Override
    public void printSplitHand() {
        //Do nothing because we aren't implementing Computer splitting yet
        
    }
    
    //Implementation of ComputerPlayer here
}
