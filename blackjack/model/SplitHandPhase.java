package blackjack.model;

public class SplitHandPhase implements State {
    @Override
    public void takeTurn(TurnManager wrapper, Player player, Dealer dealer) {
        wrapper.setState(new DealerHandPhase());
        //TODO: Add code for the play split hand phase of this turn
        //      (we arrived here because a player chose "split").
   
    }
    
    //----Helper methods------------------------------------------------------
    //TODO: Add code
    
}
