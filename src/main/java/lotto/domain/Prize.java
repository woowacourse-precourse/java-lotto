package lotto.domain;

import java.util.stream.Stream;

public enum Prize {
    FIRST(6, 2000000000),
    SECOND(5, 30000000),
    THIRD(5, 1500000),
    FOURTH(4, 50000),
    FIFTH(3, 5000),
    NONE(-1, 0);

    private final int matchingCount;
    private final int prizeMoney;


    Prize(int matchingCount, int prizeMoney) {
        this.matchingCount = matchingCount;
        this.prizeMoney = prizeMoney;
    }

    public static Prize getPrize(int lottoMatchCount, boolean bonusMatching) {
        if (lottoMatchCount == THIRD.matchingCount && bonusMatching) {
            return THIRD;
        }
        return Stream.of(values())
                .filter(prize -> prize.matchingCount == lottoMatchCount)
                .findFirst()
                .orElse(NONE);
    }

}
