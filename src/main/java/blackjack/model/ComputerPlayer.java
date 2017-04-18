package blackjack.model;

public class ComputerPlayer extends Player {
    Chips currentBet; //We'll be representing bets with chips themselves, not an int.
    Chips chips;

    
    public ComputerPlayer(String name, int startingMoney) {
        setName(name);
        turnsWon = 0;
        this.chips = new Chips(startingMoney);
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
    
    //Implementation of ComputerPlayer here
}
