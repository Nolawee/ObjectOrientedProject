package blackjack.model;

import java.io.Serializable;
import java.util.ArrayList;

/*
 * Implement Serializable for writing/loading 
 * (Unless we learn a better way to do this during lecture)
 */
public class Table implements Serializable {
    private ArrayList<Player> players; 
    private Dealer dealer;
    private TurnManager tm;
    
    public Table(ArrayList<Player> players, Dealer dealer) {
        this.players = players;
        this.dealer = dealer;
        tm = new TurnManager(this);
    }
    
    public ArrayList<Player> getPlayers() {
        return players;
    }
    
    public Dealer getDealer() {
        return dealer;
    }
    
    private void playBlackjack() {
        while (!players.isEmpty()) {
            tm.takeTurn();
            removeAnyBrokePlayer();
        }
    }
    
    private void removeAnyBrokePlayer() { 
        //If a turn causes a player to run out of chips,
        //remove them from the list of players.
    }
    
}
