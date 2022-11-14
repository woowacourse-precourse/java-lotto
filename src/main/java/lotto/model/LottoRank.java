package lotto.model;

import java.util.stream.Stream;

public enum LottoRank {
    SIXTH(0, 0),
    FIFTH(3, 5000),
    FOURTH(4, 50000),
    THIRD(5, 1500000),
    SECOND(5, 30000000),
    FIRST(6, 2000000000);

    private int matchCount;
    private int reward;

    LottoRank(int matchCount, int reward) {
        this.matchCount = matchCount;
        this.reward = reward;
    }

    public int getMatchCount() {
        return matchCount;
    }

    public int getReward() {
        return reward;
    }

    public static LottoRank matchRank(long count, boolean isBonus) {
        if (count < 3) {
            return SIXTH;
        }
        if (count != 5) {
            return Stream.of(LottoRank.values())
                    .filter(value -> value.matchCount == count)
                    .findFirst()
                    .orElseThrow(() -> new IllegalArgumentException("카운트개수가 올바르지 않음"));
        }
        if (isBonus) {
            return SECOND;
        }
        return THIRD;
    }
}
