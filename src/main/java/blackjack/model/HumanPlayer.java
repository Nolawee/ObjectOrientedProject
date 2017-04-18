package blackjack.model;

import java.util.ArrayList;

public class HumanPlayer extends Player {
    private ArrayList<Card> splitHand; //only used after choosing to "split"
    Chips currentBet; //We'll be representing bets with chips themselves, not an int.
    Chips chips;
    
    public HumanPlayer(int startingMoney) {
        turnsWon = 0;
        this.chips = new Chips(startingMoney);
    }
    
    //Implementation of HumanPlayer here
}
