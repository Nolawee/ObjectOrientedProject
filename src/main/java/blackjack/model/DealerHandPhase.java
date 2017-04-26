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
        player.clearBet();
        player.clearHand();
        dealer.clearHand();
        wrapper.nextPlayer(); 
        wrapper.setState(new BettingPhase()); 
    }
    
    
    //----Helper methods------------------------------------------------------
    
    public void playDealerHand(Player player, Dealer dealer) {
        while (dealer.mustHit()) {
            dealer.hit(dealer);
        }
        
        if (dealer.hasBusted()) {
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
    }
    
    public void handlePlayerWin(Player player, Dealer dealer) {
        //Player wins twice what they bet
        player.getChips().combineChips(player.getCurrentBet());
        player.getChips().combineChips(player.getCurrentBet()); 
        player.winTurn();
    }
    
    public void handleTie(Player player, Dealer dealer) {
        //Player gets back their bet
        player.getChips().combineChips(player.getCurrentBet());
    }
    
}