package blackjack.model;

public class TurnManager {
    private State currentState;
    private Player currentPlayer;
    private Dealer currentDealer;
    
    public TurnManager(Player player, Dealer dealer) {
        currentState = new BettingPhase(); //Every turn starts with a betting phase
        currentPlayer = player;
        currentDealer = dealer;
    }
    
    public void setState(State s) {
        currentState = s;
    }
    
    public void setPlayer(Player player) {
        currentPlayer = player;
    }
    
    public void setDealer(Dealer dealer) {
        currentDealer = dealer;
    }
    
    public void takeTurn() {
        currentState.takeTurn(this, currentPlayer, currentDealer);
    }
}
