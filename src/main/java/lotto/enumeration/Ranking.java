package lotto.enumeration;

import java.util.Arrays;

public enum Ranking {

    FIRST(2_000_000_000L,6,false),
    SECOND(30_000_000L, 5, true),
    THIRD(1_500_000L, 5, false),
    FORTH(50_000L, 4, false),
    FIFTH(5_000L, 3, false),
    NON_WINNER(0L, 0, false);

    private final int equalCount;
    private final Long prizeMoney;
    private static final int CHECK_SECOND_OR_THIRD_CONDITION = 5;

    Ranking(Long prizeMoney, int equalCount, boolean containBonus) {
        this.equalCount = equalCount;
        this.prizeMoney = prizeMoney;
    }

    public static Ranking create(int equalCount, boolean isBonusContain) {
        if (equalCount == CHECK_SECOND_OR_THIRD_CONDITION) {
            return getSecondOrThird(isBonusContain);
        }

        return Arrays.stream(Ranking.values())
                .filter(ranking -> ranking.equalCount == equalCount)
                .findFirst()
                .orElse(NON_WINNER);
    }

    private static Ranking getSecondOrThird(boolean isBonusContain) {
        if (isBonusContain){
            return Ranking.SECOND;
        }
        return Ranking.THIRD;
    }

    public Long getPrizeMoney() {
        return this.prizeMoney;
    }
}
