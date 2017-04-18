package blackjack.model;
import java.util.Random;

public class Dealer extends Player {
    //Implementation of Dealer here
    private boolean mustHit;
    private Deck deck;

    public void deal(Deck playingDeck){
    	Card dcard1,dcard2,pcard1,pcard2;
    	Random rand = new Random();
    	int  n = rand.nextInt(52) + 0;
    	//^^ Generates random number from 0-52
    	//I thik we need a joker card here that we can put in our card array so that when
    	// we pick a card and dont want to use it again we can  put the joker card in the Deck slot. 
        //That way we can generate a random number, check if our deck array at that number is a joker,
        // and return accordingly
    	
//Wasnt sure how to implement these, so here are my ideas

    }
    public void takeTurn(){
    	/*int hit =2 ;
    	int sum=0;
    	while(mustHit){
    		Card newCard1 = requestDeal();
    		Dealer.setHand(hit,hand1);
    		if(getCurrTotal(Dealer.hand) > 16){
    			mustHit = false;
    		}
    		hit++;
    }*/
    }
}
