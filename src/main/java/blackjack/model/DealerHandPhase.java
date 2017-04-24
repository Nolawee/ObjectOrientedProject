package blackjack.model;

public class DealerHandPhase implements State {
    @Override
    public void takeTurn(TurnManager wrapper, Player player, Dealer dealer) {
        //TODO: Add code for the dealer's phase of this turn
        //      (bets will be won or lost after this phase).
        while(dealer.mustHit() ){
            Card newCard1 = requestDeal();
            Dealer.setHand(hit,hand1);
            }

    //I coded this next part thinking that by here, everyone will have played their turn
    // and this is the part that picks the winner. If this is not the case please let me know.
    // Here is my reasoning for the following code:
    // By this point we know if anyone has busted. If dealer has highest total or is tied for 
    //highest total, he wins. If dealer is not highest then find highest and make him winner

        if(!dealer.hasBusted()){
            //I want to use the size of the player array from table class for my for
            //loop here, but am unsure if this is how you do it. this was my best guess after some googling.
            for(int i=0; i< Table.players.size(); i++){
                if(dealer.getHandTotal() > Table.player(i) || dealer.getHandTotal() == Table.player(i)){
                    dealer.setWinner(true);
                }
            }
        }
        // If Dealer does not win we check human players 
        if(!dealer.isWinner()){
            for(int i=0; i< Table.players.size(); i++){
                    if(HumanPlayer.getHandTotal() > Table.player(i) || HumanPlayer.getHandTotal() == Table.player(i)){
                        player.setWinner(true);
                    }
                }
            }

        //By now we should know the winner so we account for all bets
        for(int i=0; i< Table.players.size(); i++){
            Player playing = Table.player(i);
            if(playing.won()){
                playing.winTurn();
                //I need to figure out how to add chips to CurrentTotal
            }
            else{
                //here is where we would subtract chips from losers
            }
        }  

        //End turn
        wrapper.nextPlayer(); 
        wrapper.setState(new BettingPhase()); 
    }
    
    
    //----Helper methods------------------------------------------------------
    //TODO: Add code
    
}