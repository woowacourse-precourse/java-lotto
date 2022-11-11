package lotto.domain.model;

import java.util.Arrays;

public enum LottoRank {

    NONE("0", 0),
    THREE_MATCHES("3",5000),
    FOUR_MATCHES("4",50000),
    FIVE_MATCHES("5",1500000),
    FIVE_BONUS_MATCHES("5-1",30000000),
    SIX_MATCHES("6",2000000000);

    private final String matchPoint;
    private final Integer prizeMoney;
    LottoRank(final String matchPoint, final Integer prizeMoney) {
        this.matchPoint = matchPoint;
        this.prizeMoney = prizeMoney;
    }

    public static LottoRank find(String matchPoint) {
        return Arrays.stream(values()).filter(lottoRank -> lottoRank.matchPoint.equals(matchPoint)).findFirst()
                .orElse(NONE);
    }
}
