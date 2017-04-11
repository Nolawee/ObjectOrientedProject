package blackjack.model;

public class ComputerPlayer extends Player {
    int currentTotal; //Sum of chip values
    Chips currentBet; //We'll be representing bets with chips themselves, not an int.
    Chips chips;
    boolean mustHit;
    //Implementation of ComputerPlayer here
}
