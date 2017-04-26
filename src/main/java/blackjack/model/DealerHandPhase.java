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
    
    
    //----Helper methods------------------------------------------------------
    
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
            //Compare dealer and player hands
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
    
    public void handlePlayerLoss(Player player, Dealer dealer) {
        //Player wins nothing
        dealer.clearBet(); //Not really necessary since we haven't handled dealers playing like Players, but why not
        dealer.winTurn();
        
        System.out.print("Aw, you lost! "); System.out.print("The dealer won with "); dealer.printHand();
        player.clearBet();
        System.out.println("You have $" + player.getTotalMoney());
        System.out.println(); //New line
    }
    
    public void handlePlayerWin(Player player, Dealer dealer) {
        //Player wins twice what they bet
        player.getChips().combineChips(player.getCurrentBet());
        player.getChips().combineChips(player.getCurrentBet()); 
        player.winTurn();
        
        System.out.print("You won with "); player.printHand();
        System.out.println("You have $" + player.getTotalMoney());
        System.out.println(); //New line
        //Display money?
    }
    
    public void handleTie(Player player, Dealer dealer) {
        //Player gets back their bet
        player.getChips().combineChips(player.getCurrentBet());
        
        System.out.println("You have tied with the dealer. You get your bet back.");
    }
    
}