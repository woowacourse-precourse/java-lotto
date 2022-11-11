package lotto.type;

import java.util.Arrays;

public enum Rank {
    RANK_ONE(6, false, 2_000_000_000),
    RANK_TWO(5, true, 30_000_000),
    RANK_THREE(5, false, 1_500_000),
    RANK_FOUR(4, false, 50_000),
    RANK_FIVE(3, false, 5_000),
    RANK_NONE(0, false, 0);

    private final int correctCount;
    private final boolean hasBonusNumber;
    private final int winningMoney;

    Rank(int correctCount, boolean hasBonusNumber, int winningMoney) {
        this.correctCount = correctCount;
        this.hasBonusNumber = hasBonusNumber;
        this.winningMoney = winningMoney;
    }

    public int getCorrectCount() {
        return this.correctCount;
    }

    public int getWinningMoney() {
        return this.winningMoney;
    }

    public static Rank getRank(int correctCount, boolean hasBonusNumber) {
        return Arrays.stream(values())
                .filter(rank -> (rank.correctCount == correctCount) && (rank.hasBonusNumber == hasBonusNumber))
                .findFirst()
                .orElse(RANK_NONE);
    }
}
