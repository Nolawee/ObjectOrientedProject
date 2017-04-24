package blackjack.model;

import java.util.Scanner;

public class BettingPhase implements State {
    @Override
    public void takeTurn(TurnManager wrapper, Player player, Dealer dealer) {
        wrapper.setState(new PlayHandPhase()); 
        player.startPlaying();
        //NOTE: We need to figure out how we're going to prompt human players
        //      for input here. 
        //
        //      If we're making a fancy GUI, those prompts should probably
        //      happen elsewhere. 
        //      If we're just gonna do a command-line interface, right here
        //      would be the place to do that. 
        //
        //      The code below assumes we're using just a command-line interface.
        
        placePlayerBet(player);
    }
    //I (Jose) am not sure if there is anything I can add to this phase
    //If we are just doing CLI then this is pretty much all we need already for the betting
    /*
     * Takes in input from the user to place their bet on the forthcoming hand.
     * Assumes our view is a command-line interface.
     */
    public void placePlayerBet(Player player) {
        int bet;
        System.out.println("How much would you like to bet on this hand? When done entering chips to bet, enter -1.");
        //This next printout won't be needed when the view is always showing the chips
        System.out.println("The chips you have to choose from are: " ); player.getChips().printChips(); 
        System.out.println();
        
        Scanner scan = new Scanner(System.in);
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
        scan.close();
    }
    
}
