package lotto.domain;

import java.util.Arrays;

public enum Rank {
    FIRST(6, 2_000_000_000, false),
    SECOND(5, 30_000_000, true),
    THIRD(5, 1_500_000, false),
    FOURTH(3, 50_000,false),
    FIFTH(3, 5_000, false),
    NONE(0, 0, false);

    private final int matchCount;
    private final int reward;
    private final boolean hitBonusNumber;

    Rank(int matchCount, int reward, boolean hitBonusNumber) {
        this.matchCount = matchCount;
        this.reward = reward;
        this.hitBonusNumber = hitBonusNumber;
    }

    public static Rank valueOf(int matchCount, boolean hitBonusNumber) {
        return Arrays.stream(Rank.values())
                .filter(rank -> rank.matchCount == matchCount)
                .filter(rank -> rank.hitBonusNumber == hitBonusNumber)
                .findFirst()
                .orElse(NONE);
    }
}
