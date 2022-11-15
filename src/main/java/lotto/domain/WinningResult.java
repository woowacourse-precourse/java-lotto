package lotto.domain;

import java.text.NumberFormat;
import java.util.function.Function;

public enum WinningResult {
    SIX(2000000000, result -> result.getSameNumberCount() == 6, "6개 일치"),
    FIVE_AND_BONUS(30000000, result -> result.getSameNumberCount() == 5 && result.isSameBonusNumber(),
            "5개 일치, 보너스 볼 일치"),
    FIVE(1500000, result -> result.getSameNumberCount() == 5, "5개 일치"),
    FOUR(50000, result -> result.getSameNumberCount() == 4, "4개 일치"),
    THREE(5000, result -> result.getSameNumberCount() == 3, "3개 일치");

    private final int prizeMoney;
    private final Function<Result, Boolean> winningCondition;
    private final String conditionPhrase;

    WinningResult(int prizeMoney,
                  Function<Result, Boolean> winningCondition, String conditionPhrase) {
        this.prizeMoney = prizeMoney;
        this.winningCondition = winningCondition;
        this.conditionPhrase = conditionPhrase;
    }

    public boolean isWin(Result result) {
        return winningCondition.apply(result);
    }

    public static WinningResult getWinningResult(Result result) {
        for (WinningResult winningResult : WinningResult.values()) {
            if (winningResult.isWin(result)) {
                return winningResult;
            }
        }
        return null;
    }

    public int getPrizeMoney() {
        return prizeMoney;
    }

    @Override
    public String toString() {
        return String.format("%s (%s원) - ", conditionPhrase, NumberFormat.getInstance().format(prizeMoney));
    }
}
