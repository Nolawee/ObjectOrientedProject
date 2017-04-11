package blackjack.model;

public class TurnManager {
    private State currentState;
    private Player currentPlayer;
    private Dealer currentDealer;
    private Player[] players;
    private int playerIndex;
    
    public TurnManager(Player[] everyone, Dealer dealer) {
        currentState = new BettingPhase(); //Every turn starts with a betting phase
        currentPlayer = everyone[0];
        currentDealer = dealer;
        players = everyone;
        playerIndex = 0;
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
    
    public void nextPlayer() {
        try {
            setPlayer(players[playerIndex++]);
            playerIndex++;
        } catch (IndexOutOfBoundsException e) {
            setPlayer(players[0]);
            playerIndex = 0;
        }
    }
    
    public void takeTurn() {
        currentState.takeTurn(this, currentPlayer, currentDealer);
    }
}
