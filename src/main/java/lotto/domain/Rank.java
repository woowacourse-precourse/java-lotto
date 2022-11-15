package lotto.domain;

import java.util.Arrays;

public enum Rank {
    FIRST(6, 2_000_000_000), // 1등
    SECOND(5, 30_000_000), // 2등
    THIRD(5, 1_500_000), // 3등
    FOURTH(4, 50_000), // 4등
    FIFTH(3, 5_000), // 5등
    LOSE(0, 0); // 꽝

    private final int matchCount;
    private final double winningMoney;

    Rank(int matchCount, double winningMoney) {
        this.matchCount = matchCount;
        this.winningMoney = winningMoney;
    }

    public int getMatchCount() {
        return matchCount;
    }

    public double getWinningMoney() {
        return winningMoney;
    }

    public static Rank valueOf(int matchCount, boolean isMatchBonusNumber) {
        if (matchCount == THIRD.matchCount && !isMatchBonusNumber) {
            return THIRD;
        }

        return Arrays.stream(Rank.values())
                .filter(rank -> rank.matchCount == matchCount)
                .findFirst()
                .orElse(LOSE);
    }
}
