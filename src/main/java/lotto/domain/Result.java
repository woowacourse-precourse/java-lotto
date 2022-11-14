package lotto.domain;

import java.util.Arrays;

public enum Result {

    FIRST(6, 2000000000),
    SECOND(5, 30000000),
    THIRD(5, 1500000),
    FOURTH(4, 50000),
    FIFTH(3, 5000),
    NOTING(0, 0),
    ;

    private final int matchCount;
    private final long prizeMoney;

    Result(int matchCount, long prizeMoney) {
        this.matchCount = matchCount;
        this.prizeMoney = prizeMoney;
    }

    public static Result create(int matchCount, boolean hasBonusNumber) {
        if (matchCount == 5) {
            if (hasBonusNumber) {
                return SECOND;
            }
            return THIRD;
        }
        return Arrays
            .stream(Result.values())
            .filter(result -> result.getMatchCount() == matchCount)
            .findFirst()
            .orElse(NOTING);
    }

    public int getMatchCount() {
        return matchCount;
    }

    public long getPrizeMoney() {
        return prizeMoney;
    }
}
