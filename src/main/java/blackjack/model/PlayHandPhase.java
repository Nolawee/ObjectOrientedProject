package blackjack.model;

public class PlayHandPhase implements State {
    @Override
    public void takeTurn(TurnManager wrapper, Player player, Dealer dealer) {
        wrapper.setState(new DealerHandPhase());
        //TODO: Add code for the play hand phase of this turn
   
    }
    
    //----Helper methods------------------------------------------------------
    //TODO: Add code
    
}
