package blackjack.model;

public interface State {
    public void takeTurn(TurnManager wrapper, HumanPlayer human, Dealer dealer);
}
