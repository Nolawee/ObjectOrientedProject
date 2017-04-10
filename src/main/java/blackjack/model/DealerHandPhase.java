package blackjack.model;

public class DealerHandPhase implements State {
    @Override
    public void play(TurnManager wrapper, HumanPlayer human, Dealer dealer) {
        wrapper.setState(new BettingPhase()); //We might need to do more than this to advance to the next turn
        //TODO: Add code for the dealer's phase of this turn
        //      (bets will be won or lost after this phase).
   
    }
    
    //----Helper methods------------------------------------------------------
    //TODO: Add code
    
}