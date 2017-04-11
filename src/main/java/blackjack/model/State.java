package blackjack.model;

public interface State {
    public void takeTurn(TurnManager wrapper, Player player, Dealer dealer);
}
