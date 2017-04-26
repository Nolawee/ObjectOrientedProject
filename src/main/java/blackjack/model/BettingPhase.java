package blackjack.model;

import java.util.Scanner;

public class BettingPhase implements State {
    @Override
    public void takeTurn(TurnManager wrapper, Player player, Dealer dealer, Scanner scan) {
        wrapper.setState(new PlayHandPhase()); 
        player.startPlaying();
        
        placePlayerBet(player, scan);
    }
    
    //----Helper methods-------------------------------------------------------------------
    
    /*
     * Takes in input from the user to place their bet on the forthcoming hand.
     * Currently utilizes a Scanner object to take command-line input from players.
     */
    public void placePlayerBet(Player player, Scanner scan) {
        int bet;
        System.out.println("How much would you like to bet on this hand? When done entering chips to bet, enter -1.");
        //This next printout won't be needed when the view is always showing the chips
        System.out.println("The chips you have to choose from are: " ); player.getChips().printChips(); 
        System.out.println();
        
        int playerInput = 0;
        while (true) {
            try {
                System.out.println("Bet: ");
                playerInput = scan.nextInt();
                if (playerInput == -1) { //Someone might think of something cooler than typing -1. I'm not creative.
                    break;
                } else {
                    bet = playerInput;
                    player.bet(bet);
                }    
            } catch (Exception e) {
                System.out.println("You don't have a chip of value: " + playerInput + ". Try again.");    
            }
        }  
        //scan.close();
    }
    
}
