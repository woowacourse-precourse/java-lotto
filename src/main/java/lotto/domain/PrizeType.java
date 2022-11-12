package lotto.domain;

import java.util.Arrays;
import java.util.NoSuchElementException;

public enum PrizeType {
    FIRST(6, 2000000000),
    SECOND(5, 30000000),
    THIRD(5, 30000000),
    FOURTH(4, 1500000),
    FIFTH(3, 5000),
    NONE(0, 0);

    private final int numOfMatched;
    private final int prizeMoney;

    PrizeType(int numOfMatched, int prizeMoney) {
        this.numOfMatched = numOfMatched;
        this.prizeMoney = prizeMoney;
    }

    public static PrizeType getPrizeType(int numOfMatched, boolean containBonusNumber) {

        if (numOfMatched == 5 && containBonusNumber) {
            return SECOND;
        }
        if (numOfMatched < 3) {
            return NONE;
        }

        return Arrays.stream(values())
                .filter(prizeType -> prizeType.numOfMatched == numOfMatched)
                .findAny()
                .orElseThrow(NoSuchElementException::new);
    }

    public int getNumOfMatched() {
        return numOfMatched;
    }

    public int getPrizeMoney() {
        return prizeMoney;
    }
}
