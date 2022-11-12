package lotto.domain;

import java.util.Arrays;

public enum WinningCondition {
    FIRST(6, false),
    SECOND(5, true),
    THIRD(5, false),
    FORTH(4, false),
    FIFTH(3, false),
    LOSE;

    int numberOfCorrected;
    boolean isBonusCorrected;

    WinningCondition() {

    }

    WinningCondition(int numberOfCorrected, boolean isBonusCorrected) {
        this.numberOfCorrected = numberOfCorrected;
        this.isBonusCorrected = isBonusCorrected;
    }

    public static WinningCondition getRank(int numberOfCorrected, boolean isBonusCorrected) {
        return Arrays.stream(WinningCondition.values())
                .filter(wc -> wc.hasCondition(numberOfCorrected, isBonusCorrected))
                .findAny()
                .orElse(LOSE);
    }

    private boolean hasCondition(int numberOfCorrected, boolean isBonusCorrected) {
        if (numberOfCorrected == THIRD.numberOfCorrected) {
            return isBonusCorrected == this.isBonusCorrected;
        }
        return numberOfCorrected == this.numberOfCorrected;
    }
}
