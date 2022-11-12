package lotto.domain;

import java.util.Arrays;

public enum Ranking {

    FIFTH(3, 5_000, false),
    FOURTH(4, 50_000, false),
    THIRD(5, 1_500_000, false),
    SECOND(5, 30_000_000, true),
    FIRST(6, 2_000_000_000, false),
    NOTHING(0, 0, false);

    private final int rightCount;
    private final int prize;
    private final boolean hasBonusNumber;

    Ranking(int rightCount, int prize, boolean hasBonusNumber) {
        this.rightCount = rightCount;
        this.prize = prize;
        this.hasBonusNumber = hasBonusNumber;
    }

    public static Ranking findRankingByRightCountAndHasBonusNumber(int rightCount, boolean hasBonusNumber) {
        return Arrays.stream(Ranking.values())
                .filter(ranking -> ranking.rightCount == rightCount && ranking.hasBonusNumber == hasBonusNumber)
                .findAny()
                .orElse(NOTHING);
    }
}
