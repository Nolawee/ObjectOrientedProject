package blackjack.model;

import java.util.ArrayList;

public class HumanPlayer extends Player {
    private ArrayList<Card> splitHand; //only used after choosing to "split"
    Chips currentBet; //We'll be representing bets with chips themselves, not an int.
    Chips chips;
    
    public HumanPlayer(String name, int startingMoney) {
        setName(name);
        turnsWon = 0;
        this.chips = new Chips(startingMoney);
        isPlaying = false;
    }
    
    //Implementation of HumanPlayer here
}
