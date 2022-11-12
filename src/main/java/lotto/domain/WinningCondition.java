package lotto.domain;

import java.util.Arrays;

public enum WinningCondition {
    FIRST(2000000000, 6, false),
    SECOND(30000000, 5, true),
    THIRD(1500000, 5, false),
    FORTH(50000, 4, false),
    FIFTH(5000, 3, false),
    LOSE(0);

    int price;
    int numberOfCorrected;
    boolean isBonusCorrected;

    WinningCondition(int price) {
        this.price = price;
    }

    WinningCondition(int price, int numberOfCorrected, boolean isBonusCorrected) {
        this.price = price;
        this.numberOfCorrected = numberOfCorrected;
        this.isBonusCorrected = isBonusCorrected;
    }

    public static WinningCondition getRank(int numberOfCorrected, boolean isBonusCorrected) {
        return Arrays.stream(WinningCondition.values())
                .filter(wc -> wc.hasCondition(numberOfCorrected, isBonusCorrected))
                .findAny()
                .orElse(LOSE);
    }

    public int getPrice() {
        return price;
    }

    private boolean hasCondition(int numberOfCorrected, boolean isBonusCorrected) {
        if (numberOfCorrected == THIRD.numberOfCorrected) {
            return isBonusCorrected == this.isBonusCorrected;
        }
        return numberOfCorrected == this.numberOfCorrected;
    }
}
