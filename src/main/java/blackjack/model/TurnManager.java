package blackjack.model;

import java.util.ArrayList;
import java.util.Scanner;

public class TurnManager {
    private State currentState;
    private ArrayList<Player> players;
    private Player currentPlayer;
    private Dealer currentDealer;
    private int playerIndex;
    
    public TurnManager(ArrayList<Player> everyone, Dealer dealer) {
        currentState = new BettingPhase(); //Every turn starts with a betting phase
        players = everyone;
        currentPlayer = players.get(0);
        playerIndex = 0; 
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
        Scanner scan = new Scanner(System.in); //Single Scanner needed for player input to work across all states
        currentState.takeTurn(this, currentPlayer, currentDealer, scan);
    }
}
