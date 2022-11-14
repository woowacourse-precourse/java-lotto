package lotto;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public enum RankType {
    FIRST(6, true,2_000_000_000 ),
    SECOND(5, true,30_000_000),
    THIRD(5, false, 1_500_000),
    FOURTH(4, true, 50_000),
    FIFTH(3, true, 5_000),
    NONE(0, true, 0);

    private final int matchCount;
    private final boolean isBonusMatch;
    private final int reward;

    RankType(int matchCount, boolean isBonusMatch, int reward) {
        this.matchCount = matchCount;
        this.isBonusMatch = isBonusMatch;
        this.reward = reward;
    }

    public static RankType findRankType(int matchCount, boolean isBonusMatch) {
        return Stream.of(values())
                .filter(rank -> (rank.matchCount == matchCount)
                        && (rank.isBonusMatch == isBonusMatch))
                .findFirst()
                .orElse(NONE);
    }

    public int getReward() {
        return this.reward;
    }

}
