package blackjack.domain.gamer;

import blackjack.domain.card.Card;
import blackjack.domain.money.Money;

import java.util.List;

public class Player extends Gamer {

    private final Money money;

    public Player(final String name, final Money money) {
        super(name);
        this.money = money;
    }

    public double getProfit() {
        return state.profit(money);
    }

    @Override
    public boolean canDraw() {
        return !state.isFinished();
    }

    @Override
    public List<Card> showOpenHands() {
        return cards().toList();
    }
}