package blackjack.model;

import java.util.Scanner;

public interface State {
    //Scanner only needed for player input to work across all states (when communicating with command-line)
    public void takeTurn(TurnManager wrapper, Player player, Dealer dealer, Scanner scan);
}
