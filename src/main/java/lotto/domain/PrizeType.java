package lotto.domain;

import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.NoSuchElementException;

public enum PrizeType {
    FIFTH(3, 5000),
    FOURTH(4, 1500000),
    THIRD(5, 30000000),
    SECOND(5, 30000000),
    FIRST(6, 2000000000);

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

        return Arrays.stream(values())
                .filter(prizeType -> prizeType.numOfMatched == numOfMatched)
                .findAny()
                .orElseThrow(NoSuchElementException::new);
    }

    public String getNumOfMatched() {
        return numOfMatched + "개 일치 ";
    }

    public String getPrizeMoney() {
        DecimalFormat decimalFormat = new DecimalFormat("###,###");

        return "(" + decimalFormat.format(prizeMoney) + "원)";
    }
}
