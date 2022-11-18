package lotto.domain;

import java.util.Arrays;

public enum MapMatchPrize {
    NOTHING(0, 0),
    THREE(3, 5_000),
    FOUR(4, 50_000),
    FIVE(5, 1_500_000),
    FIVE_AND_BONUS(5, 30_000_000),
    SIX(6, 2_000_000_000);

    private final int numberOfMatch;
    private final int prize;

    MapMatchPrize(int numberOfMatch, int prize) {
        this.numberOfMatch = numberOfMatch;
        this.prize = prize;
    }

    public int getNumberOfMatch() {
        return this.numberOfMatch;
    }

    public int getPrize() {
        return this.prize;
    }

    public static MapMatchPrize find(int numberOfMatch) {
        return Arrays.stream(values())
                .filter(mapMatchPrize -> mapMatchPrize.numberOfMatch == numberOfMatch)
                .findAny()
                .orElse(NOTHING);
    }
}
