package lotto.domain;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public enum Rank {
    FIRST(6, false, 2_000_000_000),
    SECOND(5, true, 30_000_000),
    THIRD(5, false, 1_500_000),
    FOURTH(4, false, 50_000),
    FIFTH(3, false, 5_000),
    MISS(0, false, 0);

    private static final long DEFAULT_REWARD = 0;

    private final int matchCount;
    private final boolean matchBonusNumber;
    private final Money reward;

    Rank(int matchCount, boolean matchBonusNumber, int reward) {
        this.matchCount = matchCount;
        this.matchBonusNumber = matchBonusNumber;
        this.reward = new Money(reward);
    }

    public static Rank result(int matchCount, boolean matchBonusNumber) {
        return matchBonusNumberRank(matchBonusNumber, matchCountRanks(matchCount));
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

    private static List<Rank> matchCountRanks(int matchCount) {
        return Stream.of(Rank.values())
                .filter(rank -> rank.isMatchCountEqual(matchCount))
                .collect(Collectors.toUnmodifiableList());
    }

    private boolean isMatchCountEqual(int matchCount) {
        return this.matchCount == matchCount;
    }

    public static Money totalReward(List<Rank> lottoResult) {
        Money money = new Money(DEFAULT_REWARD);
        for (Rank rank : lottoResult) {
            money = money.add(rank.reward);
        }
        return money;
    }

    public int matchCount() {
        return this.matchCount;
    }

    public boolean matchBonusNumber() {
        return this.matchBonusNumber;
    }

    public Money reward() {
        return this.reward;
    }
}
