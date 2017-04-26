package blackjack.model;

import java.util.Scanner;

public class PlayHandPhase implements State {
    @Override
    public void takeTurn(TurnManager wrapper, Player player, Dealer dealer, Scanner scan) {
        wrapper.setState(new DealerHandPhase());
        
        dealer.shuffleDeck();
        dealer.dealStartingHands(player);
        checkForSplitHand(wrapper, player, dealer, scan);
        
        playHand(player, dealer, scan);
    }
    
    //----Helper methods------------------------------------------------------
    
    /*
     * Checks the two cards of a player's starting hand and 
     * asks them if they want to split their hand when the 
     * values of the cards match. 
     * Split the hand if they respond yes. 
     * 
     * Currently utilizes a Scanner object to take command-line input from players.
     */
    public void checkForSplitHand(TurnManager wrapper, Player player, Dealer dealer, Scanner scan) {
        if (player instanceof HumanPlayer) { //Necessary because we don't have a way to handle computer splitting yet
            Card card1 = player.getHand().get(0);
            Card card2 = player.getHand().get(1);
            if (card1.getNumber() == card2.getNumber()) {
                
                System.out.println("Would you like to split your hand? (yes/no)");
                
                //TODO: Error checking (catch bad responses and re-prompt)
                String yn = scan.nextLine(); 
                if (yn.equalsIgnoreCase("yes") || yn.equalsIgnoreCase("y")) {
                    player.split(dealer); //Splits the original hand into two hands
                    wrapper.setState(new SplitHandPhase()); //Enter this phase before the DealerHandPhase
                }
                else if (yn.equalsIgnoreCase("no") || yn.equalsIgnoreCase("n")) {
                    //Do nothing. Everything will advance like normal.
                }                
            }
        }
    }
    
    /*
     * Handles the exchange between a player and a dealer
     * during a player's turn. Prompts the player on how to 
     * react -- options are to hit, double, or stand. 
     * Turn phase ends when a player stands or goes bust.
     * 
     * Currently utilizes a Scanner object to take command-line input from players.
     */
    public void playHand(Player player, Dealer dealer, Scanner scan) {
        int handTotal;
        String hds = "";
        
        while (player.isPlaying() && !player.hasBusted()) {
            handTotal = player.getHandTotal();
            
            try {
                player.printHand(); //Won't be needed when view is always showing hands
                System.out.println("You are currently at " + handTotal + ".");
                System.out.println("Would you like to hit or stand?");
            
                hds = scan.nextLine(); 
            
                if (hds.equalsIgnoreCase("hit")) {
                    player.hit(dealer);
                }
                else if (hds.equalsIgnoreCase("double")) {
                    player.doubleBet(dealer);
                }
                else if (hds.equalsIgnoreCase("stand")) {
                    player.stand();
                }
            } catch (Exception e) {
                System.out.println("'" + hds + "' was not a valid response. Please type 'hit,' 'double,' or 'stand.'");
            }
            
            if (player.hasBusted()) { 
                System.out.println("You Busted with a total of " + handTotal); 
                player.setIsPlaying(false);
            }
        }
    }
   
 
}
