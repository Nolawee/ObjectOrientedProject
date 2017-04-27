package blackjack.model;

import java.util.ArrayList;
import java.util.Map;

//Subclasses: HumanPlayer, ComputerPlayer, Dealer
public abstract class Player {
    protected String name;
    protected int turnsWon; //renamed from "gamesWon" to be more explanatory
    protected ArrayList<Card> hand;
    protected Chips chips;
    protected Chips currentBet; //We'll be representing bets with chips themselves, not an int.
    protected boolean isPlaying;
  
    
    public void startPlaying() {
        isPlaying = true;
    }
    
    public boolean isPlaying() {
        return isPlaying;
    }

    public void setIsPlaying(boolean play) {
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
        //Sum up values of stored chips
        for (Map.Entry<Integer, Integer> entry : chips.getChips().entrySet()) {
            sum += entry.getKey() * entry.getValue();
        }
        
        //Sum up values of currently bet chips
        for (Map.Entry<Integer, Integer> entry : currentBet.getChips().entrySet()) {
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
    
    public ArrayList<Card> getHand() {
        return hand;
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
    
    public Chips getCurrentBet() {
        return currentBet;
    }
    
    public void clearBet() {
        currentBet.getChips().clear();
    }
    
    public boolean hasBusted() {
        return getHandTotal() > 21;
    }
    
    public void bet(int chipVal) throws IllegalStateException {
        int betChip = chips.takeChip(chipVal);
        currentBet.addChip(betChip);
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
    
    /*
     * If the remaining chips can double the current bet, double it.
     * (This will involve some tricky work because we can't just double
     *  a number, we have to add chips to the current bet pile. May involve
     *  adding "change making" method to Chips for returning a set of chips based on
     *  a number value; e.g. if requesting 100: return 2 50s, or 4 25s, or 1 50 & 2 25s, etc.)
     *  
     *  If the double occurs successfully, hit then stand.
     *  Throw an exception if the remaining chips can't double the bet. 
     */
    public void doubleBet(Dealer dealer) throws IllegalStateException {
        throw new IllegalStateException("Sorry! This method hasn't been implemented yet! Blame your devs."); //Temporary, of course.

//        if (getChips().getTotalValueOfChips() >= currentBet.getTotalValueOfChips()) {
//            
//        }
//        else throw new IllegalStateException("You do not have enough chips to double your bet. Sorry.");
    }
    
    public abstract void split(Dealer dealer); //Left abstract because only HumanPlayers "split" right now.
    
    public void stand() {
        isPlaying = false;
    }
    
    //----Helper methods-------------------------------------------------------
    
    public void printHand() {
        String printedHand = "HAND: [ ";
        
        for (Card card : hand) {
            printedHand +=  "" + card.getValue() + ", "; 
        }
        printedHand = printedHand.substring(0, printedHand.length()-2); //Trims the comma from the last card's number
        printedHand += " ]";
        
        System.out.println(printedHand);
    }
    
    public abstract void printSplitHand();
   
    
}
