package lotto.domain.prize;

import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.NoSuchElementException;

public enum PrizeType {
    NONE(0, 0, "0개 일치"),
    FIFTH(3, 5000, "3개 일치 (5,000원) - %d개\n"),
    FOURTH(4, 50000, "4개 일치 (50,000원) - %d개\n"),
    THIRD(5, 1500000, "5개 일치 (1,500,000원) - %d개\n"),
    SECOND(5, 30000000, "5개 일치, 보너스 볼 일치 (30,000,000원) - %d개\n"),
    FIRST(6, 2000000000, "6개 일치 (2,000,000,000원) - %d개\n");

    private final int numOfMatched;
    private final int prizeMoney;
    private final String prizeDetails;

    PrizeType(int numOfMatched, int prizeMoney, String prizeDetails) {
        this.numOfMatched = numOfMatched;
        this.prizeMoney = prizeMoney;
        this.prizeDetails = prizeDetails;
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

    public String getPrizeDetails() {
        return prizeDetails;
    }
}
