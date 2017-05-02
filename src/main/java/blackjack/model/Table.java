package blackjack.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Stack;
/*
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
*/
/*
 * Implement Serializable for writing/loading 
 * (Unless we learn a better way to do this during lecture)
 */
@Entity
public class Table implements Serializable {
	
	//@Id
	//@GeneratedValue(strategy=GenerationType.AUTO)
	private int game_id;
    private ArrayList<Player> players; 
    private Stack<Player> brokePlayers; //Keeps track of losing players. At the end of a game, repeatedly "pop" to get Players back in order of 1st place, 2nd place, etc...
    private Dealer dealer;
    private TurnManager tm;
    
    public Table(ArrayList<Player> players, Dealer dealer) {
        this.players = players;
        this.dealer = dealer;
        brokePlayers = new Stack<Player>();
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
        printWelcomeMessage();
        while (!players.isEmpty()) {
            tm.takeTurn();
            removeAnyBrokePlayer();
        }
        endGame();
    }

    //----Helper methods-------------------------------------------------------------------------------
    
    public void printWelcomeMessage() {
        String welcomeMessage = "Hello ";
        
        for (Player player : players) {
            welcomeMessage += player.getName() + ", ";
        }
        welcomeMessage += "welcome to Blackjack! Happy gambling." + System.lineSeparator();
        
        System.out.println(welcomeMessage);
    }

    /*
     * If a turn causes a player to run out of chips,
     * remove them from the list of players.
     */
    private void removeAnyBrokePlayer() { 
        Player player;
        for (int i = 0; i < players.size(); i++) {   
            player = players.get(i);
            if (player.getTotalMoney() <= 0) {
                brokePlayers.push(player); //Used so we don't lose player info after removing them
                players.remove(player); 
            }
        }
    }
    
    private void endGame() {
        //Do something after the game is over. Maybe display how players did?
        System.out.println("Game over!"); //Temporary
        //TODO: Improve this
    }
    
}
