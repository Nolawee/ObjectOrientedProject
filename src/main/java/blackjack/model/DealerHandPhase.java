package blackjack.model;

public class DealerHandPhase implements State {
    @Override
    public void takeTurn(TurnManager wrapper, Player player, Dealer dealer) {
        if (player.hasBusted()) { //Dealer automatically wins if player busted during their turn. 
            handlePlayerLoss(player, dealer);  
        }
        else {
            playDealerHand(player, dealer);
        }
        
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
    
    public void handlePlayerLoss(Player player, Dealer dealer) {
        //lose bet
    }
    
    public void handlePlayerWin(Player player, Dealer dealer) {
        //win twice what was bet
    }
    
    public void handleTie(Player player, Dealer dealer) {
        //player gets their bet back
    }
    
}