package blackjack.model;

//Subclasses: HumanPlayer, ComputerPlayer, Dealer
public abstract class Player {
    private String name;
    private int gamesWon;
    private boolean isPlaying;
    private Card[] hand;
    private Card[] splitHand; //only used after choosing to "split"
    
    //abstract public void takeTurn(); //(Commented out to avoid errors in unimplemented subclasses)
    
}
