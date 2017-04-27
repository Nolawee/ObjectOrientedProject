package blackjack.model;

import java.util.Scanner;

public class DealerHandPhase implements State {
    @Override
    public void takeTurn(TurnManager wrapper, Player player, Dealer dealer, Scanner scan) {
        if (player.hasBusted()) //Dealer automatically wins if player busted during their turn. 
            handlePlayerLoss(player, dealer);  
        else 
            playDealerHand(player, dealer);
        
        //End turn
        player.clearHand();
        dealer.clearHand();
        wrapper.nextPlayer(); 
        wrapper.setState(new BettingPhase()); 
    }
    
    
    //----Helper methods--------------------------------------------------------------------
    
    /*
     * Play through the dealer's hand then handle bets accordingly afterward.
     * Currently assumes that players interface through the command line.
     */
    public void playDealerHand(Player player, Dealer dealer) {
        dealer.printHand();
        
        while (dealer.mustHit()) {
            dealer.hit(dealer);
            
            System.out.println("The dealer has hit.");
            dealer.printHand(); 
        }
        
        if (dealer.hasBusted()) {
            System.out.println("The dealer busted!" + System.lineSeparator());
            handlePlayerWin(player, dealer);
        }
        else {
            int dealerHand = dealer.getHandTotal();
            int playerHand = player.getHandTotal();
        
            if (dealerHand < playerHand) {
                handlePlayerWin(player, dealer);
            }
            else if (dealerHand > playerHand) {
                handlePlayerLoss(player, dealer);
            }
            else if (dealerHand == playerHand) {
                handleTie(player, dealer);
            }
        }
    }
    
    /*
     * Player wins nothing
     */
    public void handlePlayerLoss(Player player, Dealer dealer) {
        dealer.clearBet(); //Not really necessary since we haven't handled Dealers playing like Players, but why not
        player.clearBet();
        dealer.winTurn();
        
        System.out.print("Aw, you lost! "); System.out.print("The dealer won with "); dealer.printHand();
        System.out.println("You have $" + player.getTotalMoney() + System.lineSeparator());
    }
    
    /*
     * Player wins twice what they bet
     */
    public void handlePlayerWin(Player player, Dealer dealer) {
        player.getChips().combineChips(player.getCurrentBet());
        player.getChips().combineChips(player.getCurrentBet()); 
        player.winTurn();
        
        System.out.print("You won with "); player.printHand();
        System.out.println("You have $" + player.getTotalMoney() + System.lineSeparator());
    }
    
    /*
     * Player gets back their bet
     */
    public void handleTie(Player player, Dealer dealer) {
        player.getChips().combineChips(player.getCurrentBet());
        
        System.out.println("You have tied with the dealer. You get your bet back.");
    }
    
}