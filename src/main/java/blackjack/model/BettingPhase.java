package blackjack.model;

import java.util.Scanner;

public class BettingPhase implements State {
    @Override
    public void takeTurn(TurnManager wrapper, Player player, Dealer dealer) {
        wrapper.setState(new PlayHandPhase()); 
        player.startPlaying();
        //TODO: Add code for the betting phase of this turn.
        //NOTE: We need to figure out how we're going to prompt human players
        //      for input here. 
        //
        //      If we're making a fancy GUI, those prompts should probably
        //      happen elsewhere. 
        //      If we're just gonna do a command-line interface, right here
        //      would be the place to do that. 
        //
        //      The code below assumes we're using just a command-line interface.
        
        int bet;
        System.out.println("How much would you like to bet on this hand?");
        //This next printout won't be needed when the view is always showing the chips
        System.out.println("The chips you have to choose from are: "); player.getChips().printChips();
        Scanner scan = new Scanner(System.in);
        bet = scan.nextInt();
        scan.close();
        
        player.bet(bet);
    }
}
