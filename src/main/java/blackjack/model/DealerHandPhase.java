package blackjack.model;

public class DealerHandPhase implements State {
    @Override
    public void takeTurn(TurnManager wrapper, Player player, Dealer dealer) {
        //TODO: Add code for the dealer's phase of this turn
        //      (bets will be won or lost after this phase).
        
        //End turn
        wrapper.nextPlayer(); 
        wrapper.setState(new BettingPhase()); 
    }
    
    
    //----Helper methods------------------------------------------------------
    //TODO: Add code
    
}