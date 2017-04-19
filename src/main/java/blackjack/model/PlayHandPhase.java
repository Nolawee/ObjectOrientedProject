package blackjack.model;

public class PlayHandPhase implements State {
    @Override
    public void takeTurn(TurnManager wrapper, Player player, Dealer dealer) {
        wrapper.setState(new DealerHandPhase());
        //TODO: Add code for the play hand phase of this turn
        //NOTE: We need to figure out how we're going to prompt human players
        //      for input here. 
        //
        //      If we're making a fancy GUI, those prompts should probably
        //      happen elsewhere. 
        //      If we're just gonna do a command-line interface, right here
        //      would be the place to do that. 
        //
        //      The code below assumes we're using just a command-line interface.
        
        while (player.isPlaying && !player.hasBusted()) {
            dealer.dealStartingHands(player);
            //TODO: code the exchange between player and dealer here.
            //      This phase of the turn ends when the player chooses 
            //      "stand" or hits too many times and goes bust. 
        }
   
    }
    
    //----Helper methods------------------------------------------------------
    //TODO: Add code if needed
    
}
