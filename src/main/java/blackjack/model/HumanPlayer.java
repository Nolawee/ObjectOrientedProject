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

    public int getSplitHandTotal() {
        int l = splithHand.size();
        int sum = 0;
        for(int i=0; i < l; i++) {
            sum += splitHand.get(i).getNumber();
        }
        return sum;
    }

    public boolean hasBustedSplit() {
        return getSplitHandTotal() > 21;
    }
    
    //Implementation of HumanPlayer here
}
