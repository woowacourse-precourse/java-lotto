package lotto.domain;

import java.util.Arrays;

public enum Rank {

    NON(0, "0", false),
    FIFTH(3, "5,000", false),
    FOURTH(4, "50,000", false),
    THIRD(5, "1,500,000", false),
    SECOND(5, "30,000,000", true),
    FIRST(6, "2,000,000,000", false);

    private static final int SECOND_AND_THIRD_WINNING_COUNT = 5;

    private final int winningNumberCount;
    private final String winningPrice;
    private final boolean isHasBonusNumber;

    Rank(int winningNumberCount, String winningPrice, boolean isHasBonusNumber) {
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

    public String getWinningPrice() {
        return winningPrice;
    }
}
