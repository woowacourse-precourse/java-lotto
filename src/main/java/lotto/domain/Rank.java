package lotto.domain;

import java.util.Arrays;

public enum Rank {
    FIRST(6, 0, 2_000_000_000),
    SECOND(5, 1, 30_000_000),
    THIRD(5, 0, 1_500_000),
    FOURTH(4, 0, 50_000),
    FIFTH(3, 0, 5_000)
    ;

    public final int matchNumbers;
    public final int matchBonus;
    public final int winAmount;

    Rank(int matchNumbers, int matchBonus, int winAmount) {
        this.matchNumbers = matchNumbers;
        this.matchBonus = matchBonus;
        this.winAmount = winAmount;
    }

    public Rank findRank(int numbersCount, int bonusCount) {
        return Arrays.stream(values())
                .filter(rank -> rank.matchNumbers == numbersCount)
                .filter(rank -> rank.matchBonus == bonusCount)
                .findAny()
                .orElse(null);
    }
}