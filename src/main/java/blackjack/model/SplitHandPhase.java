package blackjack.model;

import java.util.Scanner;

public class SplitHandPhase implements State {
    @Override
    public void takeTurn(TurnManager wrapper, Player player, Dealer dealer, Scanner scan) {
        wrapper.setState(new DealerHandPhase());
        //TODO: Add code for the play split hand phase of this turn
        //      (we arrived here because a player chose "split"
        //       and one hand has been played through without a dealer's response).
        
        /*  +---------------------+
         *  |   NOTE FROM SHAWN:  |
         *  +---------------------+
         *    Let's hold off on this phase for now? 
         *    This phase will look a lot like the PlayHandPhase,
         *    but a second & equal bet will have to be placed on the split hand
         *    and the dealer will have to play through their current hand
         *    and award bets accordingly (based on the success of the player's first hand)
         *    before the player plays through their split hand
         *    (after that comes the final dealer's response, done in the DealerHandPhase like normal).
         */
        
        
        
        
        
        //Jose's code is below, commented out to quiet errors:
        
//        Card hand1 = Player.requestDeal();//
//    	Card sHand1 = Player.requestDeal();
//    	HumanPlayer.setHand(1,hand1);
//   		HumanPlayer.setSplitHand(0,arr[1]);
//   		HumanPlayer.setSplitHand(1,sHand1);
//
//   		//Begin play for 2 hands:
//   		//I wasnt sure how to update to the new hands with the new accept dealt
//   		//card functions so I just left it like it was for now.
//        while (player.isPlaying() && !player.hasBusted()) {
//            total = player.getHandTotal();
//            System.out.println("You are currently at" + total);
//            System.out.println("Would you like to hit or stand?");
//            String hs = scanner.next();
//            if(hs == "hit"){
//                //I was not sure why we would need an extra step to 
//                //approve getting a card, or how I would go about coding that
//                //so I just did player.request
//                Card sHand1 = Player.requestDeal();
//                HumanPlayer.setHand(numHits,hand1);
//            }
//            else if(hs == "stand"){
//                wrapper.nextPlayer(); //end turn and move to next player
//                System.out.println("On to your next hand."); 
//            }
//            else{//error check
//                System.out.println("Please type hit or stand");
//            }
//            if(total >21){ //check for bust to display message
//                System.out.println("You Busted with a total of" + total);
//                System.out.println("On to your next hand."); 
//                player.setPlaying(false);
//                player.won(false);
//            }
//            numHits++;
//        }
//
//        while (player.isPlaying() && !player.hasBustedSplit()) {
//            total = player.getSplitHandTotal();
//            System.out.println("Your second hand is currently at" + total);
//            System.out.println("Would you like to hit or stand?");
//            String hs = scanner.next();
//            if(hs == "hit"){
//                //I was not sure why we would need an extra step to 
//                //approve getting a card, or how I would go about coding that
//                //so I just did player.request
//                Card sHand1 = Player.requestDeal();
//                HumanPlayer.setHand(numHits,hand1);
//            }
//            else if(hs == "stand"){
//                wrapper.nextPlayer(); //end turn and move to next player
//            }
//            else{//error check
//                System.out.println("Please type hit or stand");
//            }
//            if(total >21){ //check for bust to display message
//                System.out.println("You Busted with a total of" + total); 
//                player.setPlaying(false);
//                player.won(false);
//            }
//            numHits++;
//        }
    }


    //----Helper methods------------------------------------------------------
    //TODO: Add code
    
}
