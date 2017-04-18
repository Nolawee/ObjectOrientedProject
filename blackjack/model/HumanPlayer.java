
package blackjack.model;
import java.util.*

public class HumanPlayer extends Player {
    int currentTotal; //Sum of chip values
    Chips currentBet; //We'll be representing bets with chips themselves, not an int.
    Chips chips;
    //Implementation of HumanPlayer here

    public Card hit(){
    	Card newCard = Player.requestDeal();
    	return newCard;
    }
    public void split(Card[] arr){
    	System.out.println("Would you like to split your hand? (yes/no)");
    	String yn = scanner.next();
    	if(yn == "yes"){
    		Card hand1 = Player.requestDeal();
    		Card sHand1 = PLayer.requestDeal();
    		HumanPlayer.setHand(1,hand1);
    		HumanPlayer.setSplitHand(0,arr[1]);
    		HumanPlayer.setSplitHand(1,sHand1);
    	}		
    }
    public setBet(int bet){
    	currrentBet += bet;
    }
    public void bet(){
    	int bet;
    	System.out.println("How much would you like to bet on this hand?");
    	Scanner s=new Scanner(System.in);
		bet=s.nextInt();
    	setBet(bet);
    }
    public void doubleBet(int currentBet){
    	currentBet += currentBet;
    	//not fully sure this is what it supposed to happen
    }
    public void stand(){
    	//need some way to show currrent turn is dead
    }
    public void quit(){
    	Player.isPlaying() = false;
    }
    public Card requestDeal(){
        //im not really sure how to write this given that our deck
        //is in the dealer class
    	return newCard;
    }
    public int takeTurn(Player name){
        bet();
        requestDeal
    	return 0;
    }
}

