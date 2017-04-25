package blackjack.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Stack;

/*
 * Implement Serializable for writing/loading 
 * (Unless we learn a better way to do this during lecture)
 */
public class Table implements Serializable {
    private ArrayList<Player> players; 
    private Stack<Player> brokePlayers; //Keeps track of losing players. At the end of a game, repeatedly "pop" to get Players back in order of 1st place, 2nd place, etc...
    private Dealer dealer;
    private TurnManager tm;
    
    public Table(ArrayList<Player> players, Dealer dealer) {
        this.players = players;
        this.dealer = dealer;
        tm = new TurnManager(players, dealer);
    }
    
    public ArrayList<Player> getPlayers() {
        return players;
    }
    
    public Dealer getDealer() {
        return dealer;
    }
    
    /*
     * The central method of this game.
     * Players take turns playing Blackjack
     * against a single dealer until they 
     * successively run out of chips and get
     * removed from play. Game ends when all
     * players have gone broke.
     */
    public void playBlackjack() {
        while (!players.isEmpty()) {
            tm.takeTurn();
            removeAnyBrokePlayer();
        }
    }
    
    /*
     * If a turn causes a player to run out of chips,
     * remove them from the list of players.
     */
    private void removeAnyBrokePlayer() { 
        for (Player player : players) {   
            if (player.getTotalMoney() <= 0){
                brokePlayers.push(player); //Used so we don't lose player info after removing them
                players.remove(player);
            }
        }
    }
    
}
