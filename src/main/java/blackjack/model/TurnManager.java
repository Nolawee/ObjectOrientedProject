package blackjack.model;

import java.util.ArrayList;

public class TurnManager {
    private State currentState;
    private Player currentPlayer;
    private Dealer currentDealer;
    private ArrayList<Player> players;
    private int playerIndex;
    
    public TurnManager(Table tableWrapper) {
        currentState = new BettingPhase(); //Every turn starts with a betting phase
        currentPlayer = tableWrapper.getPlayers().get(0); 
        playerIndex = 0; 
        currentDealer = tableWrapper.getDealer();
        players = tableWrapper.getPlayers();
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
            setPlayer(players.get(playerIndex++));
            playerIndex++;
        } catch (IndexOutOfBoundsException e) {
            setPlayer(players.get(0));
            playerIndex = 0;
        }
    }
    
    public void takeTurn() {
        currentState.takeTurn(this, currentPlayer, currentDealer);
    }
}
