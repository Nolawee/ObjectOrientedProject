package blackjack.model;

//Subclasses: HumanPlayer, ComputerPlayer, Dealer
public abstract class Player {
    private String name;
    private int gamesWon;
    private boolean isPlaying; //PROBABLY NOT NEEDED
    private Card[] hand;
    private Card[] splitHand; //only used after choosing to "split"
    
    //abstract public void takeTurn(); //(PROBABLY NOT NEEDED because of TurnManager. 
                                       //Commented out to avoid errors in unimplemented subclasses)
    
}
