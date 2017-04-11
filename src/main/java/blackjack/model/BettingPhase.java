package blackjack.model;

public class BettingPhase implements State {
    @Override
    public void takeTurn(TurnManager wrapper, HumanPlayer human, Dealer dealer) {
        wrapper.setState(new PlayHandPhase()); 
        //TODO: Add code for the betting phase of this turn
   
    }
    
    //----Helper methods------------------------------------------------------
    //TODO: Add code
    
}
