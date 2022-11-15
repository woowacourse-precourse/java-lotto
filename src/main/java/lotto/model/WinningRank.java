package lotto.model;

import java.util.Arrays;

public enum WinningRank {
    NO_MATCH(0, false, 0),
    THREE_MATCH(3, false, 5000),
    FOUR_MATCH(4, false, 50000),
    FIVE_MATCH(5, false, 1500000),
    FIVE_MATCH_BONUS(5, true, 30000000),
    SIX_MATCH(6, false, 2000000000);


    private final int matchingCount;
    private final boolean containsBonusNumber;
    private final int winningAmount;

    WinningRank(int matchingCount, boolean containsBonusNumber, int winningPrice) {
        this.matchingCount = matchingCount;
        this.containsBonusNumber = containsBonusNumber;
        this.winningAmount = winningPrice;
    }


    public static WinningRank findWinningRank(int matchingCount, boolean containsBonusNumber) {
        return Arrays.stream(values())
                .filter(winningRank -> winningRank.matchingCount == matchingCount)
                .filter(winningRank -> winningRank.containsBonusNumber == containsBonusNumber)
                .findFirst()
                .orElse(WinningRank.NO_MATCH);
    }


    public int getMatchingCount() {
        return matchingCount;
    }

    public int getWinningAmount() {
        return winningAmount;
    }
}