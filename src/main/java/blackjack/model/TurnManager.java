package blackjack.model;

import java.util.ArrayList;

public class TurnManager {
    //TODO: The actions performed on these players are meant to affect
    //      the real players held in Table. If Java is doing pass-by-value
    //      here, this will NOT be the case, and a refactor will be needed
    //      to propagate the changes up to Table.
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
