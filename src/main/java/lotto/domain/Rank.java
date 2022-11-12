package lotto.domain;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public enum Rank {
    FIRST(1, 6, false, 2_000_000_000),
    SECOND(2, 5, true, 30_000_000),
    THIRD(3, 5, false, 1_500_000),
    FOURTH(4, 4, false, 50_000),
    FIFTH(5, 3, false, 5_000),
    MISS(0, 0, false, 0);

    private final int rank;
    private final int matchCount;
    private final boolean matchBonusNumber;
    private final long reward;

    Rank(int rank, int matchCount, boolean matchBonusNumber, int reward) {
        this.rank = rank;
        this.matchCount = matchCount;
        this.matchBonusNumber = matchBonusNumber;
        this.reward = reward;
    }


    public static Rank result(int matchCount, boolean matchBonusNumber) {
        return matchBonusNumberRank(matchBonusNumber, matchCountRanks(matchCount));
    }

    private static List<Rank> matchCountRanks(int matchCount) {
        return Stream.of(Rank.values())
                .filter(rank -> rank.isMatchCountEqual(matchCount))
                .collect(Collectors.toList());
    }

    private boolean isMatchCountEqual(int matchCount) {
        return this.matchCount == matchCount;
    }

    private static Rank matchBonusNumberRank(boolean matchBonusNumber, List<Rank> matchCountRanks) {
        return matchCountRanks.stream()
                .filter(rank -> rank.isMatchBonusNumber(matchBonusNumber))
                .findFirst()
                .orElse(matchCountRanks.stream().findFirst().orElse(Rank.MISS));
    }

    private boolean isMatchBonusNumber(boolean matchBonusNumber) {
        return this.matchBonusNumber == matchBonusNumber;
    }
}
