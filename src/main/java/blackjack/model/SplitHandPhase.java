package blackjack.model;

public class SplitHandPhase implements State {
    @Override
    public void takeTurn(TurnManager wrapper, HumanPlayer human, Dealer dealer) {
        wrapper.setState(new DealerHandPhase());
        //TODO: Add code for the play split hand phase of this turn
        //      (we arrived here because a human player chose "split").
   
    }
    
    //----Helper methods------------------------------------------------------
    //TODO: Add code
    
}
