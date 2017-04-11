package blackjack.model;

//Subclasses: HumanPlayer, ComputerPlayer, Dealer
public abstract class Player {
    private String name;
    private int gamesWon;
    private Card[] hand;
    private Card[] splitHand; //only used after choosing to "split"
    
    /*abstract public void takeTurn();*/ //NOT USED because of TurnManager. 
                                       //Leaving this here temporarily to alert our team
                                       //because this varies from our class diagram.
                                     
}
