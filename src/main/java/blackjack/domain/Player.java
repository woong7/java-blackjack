package blackjack.domain;

import static blackjack.domain.Cards.HIGHEST_POINT;

import blackjack.view.InputView;
import blackjack.view.OutputView;
import java.util.Map;

public class Player extends Gamer {
    private static final String GET_CARD = "y";
    private static final String ERROR_Y_OR_N = "y 혹은 n 만 입력하여 주십시오.";
    private static final String PATTERN_Y_OR_N = "[yn]";
    private String result;

    public Player(String name) {
        super(name);
    }

    @Override
    public boolean canReceiveCard() {
        return this.getPoint() < HIGHEST_POINT;
    }

    public Boolean continueDraw(Deck deck) {
        OutputView.noticeGetMoreCard(getName());
        String draw = InputView.isContinueDraw();
        if (isDrawCard(draw)) {
            receiveCard(deck.dealCard());
            OutputView.printPlayerInfo(this);
            return true;
        }
        return false;
    }

    private Boolean isDrawCard(String draw) {
        if (!draw.matches(PATTERN_Y_OR_N)) {
            throw new IllegalArgumentException(ERROR_Y_OR_N);
        }
        return draw.equals(GET_CARD);
    }

    public void recordMatchResult(String result) {
        this.result = result;
    }

    public String getResult() {
        return result;
    }

    public void judgeVictory(Map<String, Integer> dealerHistory, int dealerPoint) {
        int playerPoint = getPoint();

        Result result = Result.getInstance(playerPoint, dealerPoint);
        inputMatchResult(dealerHistory, result.name());
        recordMatchResult(result.getMessage());
    }

    private void inputMatchResult(Map<String, Integer> dealerHistory, String result) {
        dealerHistory.put(result, dealerHistory.get(result) + 1);
    }
}