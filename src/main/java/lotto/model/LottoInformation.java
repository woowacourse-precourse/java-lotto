package lotto.model;

import java.util.HashMap;
import java.util.Map;

public enum LottoInformation {
    NONE(0, 0, 0), FIRST(1, 2000000000, 6), SECOND(2, 30000000, 5), THIRD(3, 1500000, 5),
    FOURTH(4, 50000, 4), FIFTH(5, 5000, 3);

    public static final Map<Integer, LottoInformation> convertPrizeNumberToLottoInfo =
            new HashMap<>() {
                {
                    put(0, NONE);
                    put(1, FIRST);
                    put(2, SECOND);
                    put(3, THIRD);
                    put(4, FOURTH);
                    put(5, FIFTH);
                }
            };
    public final int prizeNumber;
    public final int prizeMoney;
    public final int matchCount;

    LottoInformation(int prizeNumber, int prizeMoney, int matchCount) {
        this.prizeNumber = prizeNumber;
        this.prizeMoney = prizeMoney;
        this.matchCount = matchCount;
    }
}
