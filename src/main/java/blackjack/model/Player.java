package blackjack.model;

import java.util.ArrayList;
import java.util.Map;

//Subclasses: HumanPlayer, ComputerPlayer, Dealer
public abstract class Player {
    protected String name;
    protected int turnsWon; //renamed from "gamesWon" to be more explanatory
    private ArrayList<Card> hand;
    protected Chips chips;
    private Chips currentBet; //We'll be representing bets with chips themselves, not an int.
    protected boolean isPlaying;
    protected boolean winner;
    
    /*abstract public void takeTurn();*/ //NOT USED because TurnManager handles taking turns. 
                                         //Leaving this here temporarily to alert our team
                                         //because this varies from our class diagram. 
    
    public void startPlaying() {
        isPlaying = true;
    }
    
    public boolean isPlaying() {
        return isPlaying;
    }

    public void setPlaying(boolean play){
        isPlaying = play;
    }
    
    public String getName() {
        return name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    public Chips getChips() {
        return chips;
    }
    
    public int getTotalMoney() {
        int sum = 0;
        for (Map.Entry<Integer, Integer> entry : chips.getChips().entrySet()) {
            sum += entry.getKey() * entry.getValue();
        }
        return sum;
    }
    
    public void winTurn() {
        turnsWon++;
    }
    
    public void acceptDealtCard(Card c) {
        hand.add(c);
    }
    
    public void requestDeal(Dealer dealer) {
        dealer.processDealRequest(this);
    }
    
    public void clearHand() {
        hand.clear();
    }
    
    public int getHandTotal() {
        int l = hand.size();
        int sum = 0;
        for(int i=0; i < l; i++) {
            sum += hand.get(i).getNumber();
        }
        return sum;
    }
    
    public boolean hasBusted() {
        return getHandTotal() > 21;
    }
    
    public void bet(int chipVal) throws IllegalStateException {
        int betChip = chips.takeChip(chipVal);
        currentBet.addChip(betChip);
    }

    public boolean won(){
        return iswinner;
    }

    public void setWinner(boolean isWinner){
        winner = isWinner;
    }

    /*
     * Note: passing a dealer into the method signature because
     * we need the Dealer to do something is becoming necessary/common 
     * enough that we might consider just giving Players a dealer 
     * outright as a member variable.
     * Having a dealer as a member variable to reference in methods
     * like this might be a nicer solution than always passing in one;
     * I'm not sold either way yet.
     * 
     * This method only calls another method from Player, but we keep
     * it because it gives us the benefit of being able to say "hit". 
     */
    public void hit(Dealer dealer) {
        requestDeal(dealer);
    }
    
    public void stand() {
        isPlaying = false;
    }
}
