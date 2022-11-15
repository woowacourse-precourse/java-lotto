package lotto.domain;

import java.util.Arrays;

public enum Rank {
    FIRST(0, 6, 0, 2_000_000_000),
    SECOND(1, 5, 1, 30_000_000),
    THIRD(2, 5, 0, 1_500_000),
    FOURTH(3, 4, 0, 50_000),
    FIFTH(4,3, 0, 5_000)
    ;

    private final int index;
    private final int matchNumbers;
    private final int matchBonus;
    private final int winAmount;

    Rank(int index, int matchNumbers, int matchBonus, int winAmount) {
        this.index = index;
        this.matchNumbers = matchNumbers;
        this.matchBonus = matchBonus;
        this.winAmount = winAmount;
    }

    public int getWinAmount() {
        return this.winAmount;
    }

    public int getIndex() {
        return this.index;
    }

    public Rank getRank(int index) {
        return Arrays.stream(values())
                .filter(rank -> rank.index == index)
                .findAny()
                .orElse(null);
    }

    public static Rank findRank(int numbersCount, int bonusCount) {
        return Arrays.stream(values())
                .filter(rank -> rank.matchNumbers == numbersCount)
                .filter(rank -> rank.matchBonus == bonusCount)
                .findAny()
                .orElse(null);
    }
}