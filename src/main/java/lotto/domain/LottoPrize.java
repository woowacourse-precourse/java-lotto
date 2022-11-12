package lotto.domain;

import java.util.Arrays;

public enum LottoPrize {
    FIRST(6, false),
    SECOND(5, true),
    THIRD(5, false),
    FOURTH(4, false),
    FIFTH(3, false),
    NONE(0, false);

    private int matchCount;
    private boolean isMatchBonusNumber;

    LottoPrize(int matchCount, boolean isMatchBonusNumber) {
        this.matchCount = matchCount;
        this.isMatchBonusNumber = isMatchBonusNumber;
    }

    public static LottoPrize getPrize(int matchCount, boolean isMatchBonusNumber) {
        return Arrays.stream(LottoPrize.values())
                .filter(prize -> prize.matchCount == matchCount && prize.isMatchBonusNumber == isMatchBonusNumber)
                .findAny()
                .orElse(NONE);
    }
}
