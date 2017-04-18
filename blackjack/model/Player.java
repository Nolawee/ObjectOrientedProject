package blackjack.model;

//Subclasses: HumanPlayer, ComputerPlayer, Dealer
public abstract class Player {
    private String name;
    private int gamesWon;
    private Card[] hand;
    private Card[] splitHand; //only used after choosing to "split"
    private Chips chips;
    private boolean isPlaying ;
    
    /*abstract public void takeTurn();*/ //NOT USED because of TurnManager. 
                                         //Leaving this here temporarily to alert our team
                                         //because this varies from our class diagram. 
    //Added a couple funcitons to this class
    public Chips getChips() {
        return chips;
    }
    public void setHand(int t, Card c){
        hand[t] = c;

    }
    public void setSplitHand(int t, Card c){
        hand[t] = c;
    }
    public int getCurrTotal(Card[] arr){
        int l = arr.length();
        int sum;
        for(int i =0; i < l ;i++){
            sum += arr[i].getNumber();
        }
    }
}
