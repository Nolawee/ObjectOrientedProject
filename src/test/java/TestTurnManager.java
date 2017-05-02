import java.util.ArrayList;
import blackjack.model.*;
import blackjack.view.*;

public class TestTurnManager {
    
    public static void main(String[] args) {
        Player p = new HumanPlayer("Jesus", 12550);
        
        Dealer d = new Dealer();
        ArrayList<Player> players = new ArrayList<Player>();
        players.add(p);
        
        //Table table = new Table(players, d);
        MainMenu mainMenu = new MainMenu();
        
        MainMenu.main(null);
        
        //table.playBlackjack();
    }
}
