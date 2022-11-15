package lotto.domain;

import java.text.NumberFormat;

public enum Result {
    THREE(3, false, 5000L),
    FOUR(4, false, 50000L),
    FIVE(5, false, 1500000L),
    FIVE_AND_BONUS(5, true, 30000000L),
    SIX(6, false, 2000000000L);

    private final int winningPoint;
    private final boolean bonusPoint;
    private final long prize;

    Result(int winningPoint, boolean bonusPoint, long prize) {
        this.winningPoint = winningPoint;
        this.bonusPoint = bonusPoint;
        this.prize = prize;
    }

    public long calculate(long value) {
        return value * prize;
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

    public String toString(int count) {
        if (bonusPoint) {
            return winningPoint + "개 일치, 보너스 볼 일치 (" + NumberFormat.getInstance().format(prize) + "원) - " + count + "개";
        }
        return winningPoint + "개 일치 (" + NumberFormat.getInstance().format(prize) + "원) - " + count + "개";
    }
}
