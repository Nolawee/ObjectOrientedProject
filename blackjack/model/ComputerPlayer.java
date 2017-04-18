package blackjack.model;

public class ComputerPlayer extends Player {
    int currentTotal; //Sum of chip values
    Chips currentBet; //We'll be representing bets with chips themselves, not an int.
    Chips chips;
    boolean mustHit;
    //Implementation of ComputerPlayer here

    public Card hit(){
    	Card newCard = Player.requestDeal();
    	return newCard;
    }
    // public void split(){
    //seems like this would be an unecessary & difficult logical 
    // task to implement for our computer player
    // }
    public void bet(int bet){
    	currentBet = bet;
    }
    public void doubleBet(int currBet){
    	currentBet += currBet;
    	//not fully sure this is what it supposed to happen
        //Should comp player be allowed to do this?
    }
    public void stand(){
    	//need some way to show currrent turn is dead
    }
    public void quit(){
    	Player.isPlaying() = false;
    }
    public Card requestDeal(){
    	Card newCard = Player.requestDeal();
    	Card newCard2 = Player.requestDeal();
    	hand[1] = newCard1;
    	hand[2] = newCard2;
    	return newCard;
    }
    public int takeTurn(Player name){
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
    	return 0;
    }
    // public setBet(){}  bet does same thing
}
