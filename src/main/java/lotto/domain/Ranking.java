package lotto.domain;

import java.util.Arrays;

public enum Ranking {
    NOTHING(0, 0, false),
    FIFTH(5_000, 3, false),
    FOURTH(50_000, 4, false),
    THIRD(1_500_000, 5, false),
    SECOND(30_000_000, 5, true),
    FIRST(2_000_000_000, 6, false);

    private static final int BONUS_BALL_CHECK_CONDITION = 5;
    private final int prize;
    private final int count;
    private final boolean hasBonusNumber;

    Ranking(int prize, int count, boolean hasBonusNumber) {
        this.prize = prize;
        this.count = count;
        this.hasBonusNumber = hasBonusNumber;
    }

    public static Ranking findRanking(int cnt, boolean hasBonusNumber) {
        if (cnt == BONUS_BALL_CHECK_CONDITION && hasBonusNumber) {
            return SECOND;
        }
        return Arrays.stream(values())
                .filter(ranking -> ranking.count == cnt)
                .findFirst()
                .orElse(NOTHING);
    }

    public int getPrize() {
        return prize;
    }

    public int getCount() {
        return count;
    }
}
