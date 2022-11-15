package lotto.domain;

import java.util.Arrays;

public enum Rank {
    FIRST(0, 6, 0, 2_000_000_000, "6개 일치 (2,000,000,000원) - "),
    SECOND(1, 5, 1, 30_000_000, "5개 일치, 보너스 볼 일치 (30,000,000원) - "),
    THIRD(2, 5, 0, 1_500_000, "5개 일치 (1,500,000원) - "),
    FOURTH(3, 4, 0, 50_000, "4개 일치 (50,000원) - "),
    FIFTH(4,3, 0, 5_000, "3개 일치 (5,000원) - ")
    ;

    private final int index;
    private final int matchNumbers;
    private final int matchBonus;
    private final int winAmount;
    private final String message;

    public static final int length = 5;

    Rank(int index, int matchNumbers, int matchBonus, int winAmount, String message) {
        this.index = index;
        this.matchNumbers = matchNumbers;
        this.matchBonus = matchBonus;
        this.winAmount = winAmount;
        this.message = message;
    }

    public int getWinAmount() {
        return this.winAmount;
    }

    public int getIndex() {
        return this.index;
    }

    public static Rank getRank(int index) {
        return Arrays.stream(values())
                .filter(rank -> rank.index == index)
                .findAny()
                .orElse(null);
    }

    public String getMessage() {
        return this.message;
    }

    public static Rank findRank(int numbersCount, int bonusCount) {
        return Arrays.stream(values())
                .filter(rank -> rank.matchNumbers == numbersCount)
                .filter(rank -> rank.matchBonus == bonusCount)
                .findAny()
                .orElse(null);
    }
}