package lotto.model.machine;

import java.util.stream.Stream;

public enum Rank {

    FIRST(6, 2_000_000_000),
    SECOND(7, 30_000_000),
    THIRD(5, 1_500_000),
    FOURTH(4, 50_000),
    FIFTH(3, 5_000);

    private final Integer matchCount;
    private final Integer money;

    Rank(Integer matchCount, Integer money) {
        this.matchCount = matchCount;
        this.money = money;
    }

    public Integer getMatchCount() {
        return matchCount;
    }

    public static float getRankMoney(int i) {
        for (Rank rank : Rank.values()) {
            if (rank.matchCount == i) {
                return rank.money;
            }
        }
        return 0;
    }

    public static boolean isMatchCount(Integer matchCount) {
        return Stream.of(FIRST, SECOND, THIRD, FOURTH, FIFTH)
                .anyMatch(rank -> matchCount.equals(rank.getMatchCount()));
    }

}
