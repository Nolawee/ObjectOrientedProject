package blackjack.model;

public class TurnManager {
    private State currentState;
    private HumanPlayer currentHuman;
    private Dealer currentDealer;
    
    public TurnManager(HumanPlayer human, Dealer dealer) {
        currentState = new BettingPhase(); //Every turn starts with a betting phase
        currentHuman = human;
        currentDealer = dealer;
    }
    
    public void setState(State s) {
        currentState = s;
    }
    
    public void setHumanPlayer(HumanPlayer human) {
        currentHuman = human;
    }
    
    public void setDealer(Dealer dealer) {
        currentDealer = dealer;
    }
    
    public void takeTurn() {
        currentState.takeTurn(this, currentHuman, currentDealer);
    }
}
