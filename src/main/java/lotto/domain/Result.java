package lotto.domain;

import java.util.function.Function;

public enum Result {
    THREE(3, false, value -> value * 5000L),
    FOUR(4, true, value -> value * 50000L),
    FIVE(5, false, value -> value * 1500000L),
    FIVE_AND_BONUS(5, true, value -> value * 30000000L),
    SIX(6, true, value -> value * 2000000000L);

    private final int winningPoint;
    private final boolean bonusPoint;
    private Function<Long, Long> expression;

    Result(int winningPoint, boolean bonusPoint, Function<Long, Long> expression) {
        this.winningPoint = winningPoint;
        this.bonusPoint = bonusPoint;
    }

    private long calculate(long value) {
        return expression.apply(value);
    }

    public boolean isWin(int winningPoint, boolean bonusPoint) {
        if (winningPoint == 5 && this.winningPoint == winningPoint) {
            return this.bonusPoint == bonusPoint;
        }
        if (this.winningPoint == winningPoint) {
            return true;
        }
        return false;
    }
}
