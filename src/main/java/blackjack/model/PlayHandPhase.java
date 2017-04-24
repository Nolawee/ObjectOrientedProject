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
        
        dealer.shuffleDeck();
        dealer.dealStartingHands(player);
        numHits = 2; //tracks number of times player has chosen to hit to add to card array
        Card card1 = player.hand(0);
        Card card2 = player.hand(1);
        if(card1.getNumber() == card2.getNumber()){
            //check for possibility of splitting hand
            System.out.println("Would you like to split your hand? (yes/no)");
            String yn = scanner.next();
            if(yn == "yes"){
                //I have no idea if this is how you switch to the new state
                //so im just guessing, but this is where we go from normal hand to split
                wrapper.setState(new SplitHandPhase());
            }
        }

        while (player.isPlaying() && !player.hasBusted()) {
            //TODO: code the exchange between player and dealer here.
            //      This phase of the turn ends when the player chooses 
            //      "stand" or hits too many times and goes bust. 

            total = player.getHandTotal();
            System.out.println("You are currently at" + total);
            System.out.println("Would you like to hit or stand?");
            String hs = scanner.next();
            if(hs == "hit"){
                //I was not sure why we would need an extra step to 
                //approve getting a card, or how I would go about coding that
                //so I just did player.request
                Card sHand1 = Player.requestDeal();
                HumanPlayer.setHand(numHits,hand1);
            }
            else if(hs == "stand"){
                wrapper.nextPlayer(); //end turn and move to next player
            }
            else{//error check
                System.out.println("Please type hit or stand");
            }
            if(total >21){ //check for bust to display message
                System.out.println("You Busted with a total of" + total); 
                player.setPlaying(false);
                player.won(false);
            }
            numHits++;
        }
   
    }
    
    //----Helper methods------------------------------------------------------
    //TODO: Add code if needed
    
}
