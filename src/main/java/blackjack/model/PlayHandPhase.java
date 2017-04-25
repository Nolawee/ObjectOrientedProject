package blackjack.model;

import java.util.Scanner;

public class PlayHandPhase implements State {
    @Override
    public void takeTurn(TurnManager wrapper, Player player, Dealer dealer) {
        wrapper.setState(new DealerHandPhase());
        //NOTE: We need to figure out how we're going to prompt human players
        //      for input here. 
        //
        //      If we're making a fancy GUI, those prompts should probably
        //      happen elsewhere. 
        //      If we're just gonna do a command-line interface, right here
        //      would be the place to do that. 
        //
        //      The code below assumes we're using just a command-line interface
        //      and fully implements everything this class would need to do 
        //      (but could be improved, especially the user prompts).
        
        dealer.shuffleDeck();
        dealer.dealStartingHands(player);
        checkForSplitHand(wrapper, player, dealer);
        
        playHand(player, dealer);
    }
    
    //----Helper methods------------------------------------------------------
    
    /*
     * Checks the two cards of a player's starting hand and 
     * asks them if they want to split their hand when the 
     * values of the cards match. 
     * Split the hand if they respond yes. 
     */
    public void checkForSplitHand(TurnManager wrapper, Player player, Dealer dealer) {
        if (player instanceof HumanPlayer) { //Necessary because we don't have a way to handle computer splitting yet
            Card card1 = player.getHand().get(0);
            Card card2 = player.getHand().get(1);
            if (card1.getNumber() == card2.getNumber()) {
                
                System.out.println("Would you like to split your hand? (yes/no)");
                Scanner scan = new Scanner(System.in);
                String yn = scan.next();
                
                //TODO: Error checking (catch bad responses and re-prompt)
                if (yn.equalsIgnoreCase("yes") || yn.equalsIgnoreCase("y")) {
                    player.split(dealer); //Splits the original hand into two hands
                    wrapper.setState(new SplitHandPhase()); //Enter this phase before the DealerHandPhase
                }
                scan.close();
            }
        }
    }
    
    /*
     * Handles the exchange between a player and a dealer
     * during a player's turn. Prompts the player on how to 
     * react -- options are to hit, double, or stand. 
     * Turn phase ends when a player stands or goes bust.
     */
    public void playHand(Player player, Dealer dealer) {
        int handTotal;
        Scanner scan = new Scanner(System.in);
        
        while (player.isPlaying() && !player.hasBusted()) {
            handTotal = player.getHandTotal();
            
            player.printHand(); //Won't be needed when view is always showing hands
            System.out.println("You are currently at " + handTotal + ".");
            System.out.println("Would you like to hit or stand?");
            String hds = scan.nextLine();
            
            if (hds.equalsIgnoreCase("hit")) {
                player.hit(dealer);
            }
            else if (hds.equalsIgnoreCase("double")) {
                player.doubleBet(dealer);
            }
            else if (hds.equalsIgnoreCase("stand")) {
                player.stand();
            }
            else { //Error checking (catch bad responses and re-prompt)
                System.out.println("'" + hds + "' was not a valid response. Please type 'hit,' 'double,' or 'stand.'");
            }
            
            if (player.hasBusted()) { 
                System.out.println("You Busted with a total of " + handTotal); 
                player.setIsPlaying(false);
            }
        }
        scan.close();
    }
   
 
}
