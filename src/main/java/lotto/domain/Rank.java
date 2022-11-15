package lotto.domain;

import java.util.Arrays;

public enum Rank {

    NON(0, 0, false),
    FIFTH(3, 5000, false),
    FOURTH(4, 50000, false),
    THIRD(5, 1500000, false),
    SECOND(5, 30000000, true),
    FIRST(6, 2000000000, false);

    private static final int SECOND_AND_THIRD_WINNING_COUNT = 5;

    private final int winningNumberCount;
    private final int winningPrice;
    private final boolean isHasBonusNumber;

    Rank(int winningNumberCount, int winningPrice, boolean isHasBonusNumber) {
        this.winningNumberCount = winningNumberCount;
        this.winningPrice = winningPrice;
        this.isHasBonusNumber = isHasBonusNumber;
    }

    public static Rank valueOf(int winningNumberCount, boolean isHasBonusNumber) {
        if (winningNumberCount == SECOND_AND_THIRD_WINNING_COUNT && isHasBonusNumber) {
            return Rank.SECOND;
        }

        return Arrays.stream(values())
                .filter(rank -> rank.winningNumberCount == winningNumberCount)
                .filter(rank -> !rank.isHasBonusNumber)
                .findFirst()
                .orElse(NON);
    }

    public int getWinningNumberCount() {
        return winningNumberCount;
    }

    public int getWinningPrice() {
        return winningPrice;
    }

    public boolean getIsHasBonusNumber() {
        return isHasBonusNumber;
    }
}
