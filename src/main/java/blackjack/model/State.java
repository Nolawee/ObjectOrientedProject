package blackjack.model;

public interface State {
    void play(TurnManager wrapper, HumanPlayer human, Dealer dealer);
}
