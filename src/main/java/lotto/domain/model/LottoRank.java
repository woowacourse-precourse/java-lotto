package lotto.domain.model;

import static lotto.domain.view.IOMessage.BONUS_STATISTICS_MESSAGE;
import static lotto.domain.view.IOMessage.STANDARD_STATISTICS_MESSAGE;

import java.text.DecimalFormat;
import java.util.Arrays;

public enum LottoRank {

    NONE("0", 0L),
    THREE_MATCHES("3",5000L),
    FOUR_MATCHES("4",50000L),
    FIVE_MATCHES("5",1500000L),
    FIVE_BONUS_MATCHES("5",30000000L),
    SIX_MATCHES("6",2000000000L);


    private final String matchPoint;
    private final Long reward;
    LottoRank(final String matchPoint, final Long prizeMoney) {
        this.matchPoint = matchPoint;
        this.reward = prizeMoney;
    }

    public Long getReward() {
        return reward;
    }

    public static LottoRank find(String matchPoint) {
        return Arrays.stream(values()).filter(lottoRank -> lottoRank.matchPoint.equals(matchPoint)).findFirst()
                .orElse(NONE);
    }

    public static LottoRank of(LottoRank lottoRank, Boolean isBonusMatch) {
        if (lottoRank == FIVE_MATCHES && isBonusMatch) {
            return FIVE_BONUS_MATCHES;
        }
        return lottoRank;
    }

    public static String createStatisticsForm(LottoRank lottoRank, Long count) {
        DecimalFormat decFormat = new DecimalFormat("###,###");
        if (lottoRank == FIVE_BONUS_MATCHES) {
            return String.format(BONUS_STATISTICS_MESSAGE.getMessage(), lottoRank.matchPoint,
                    decFormat.format(lottoRank.reward), count);
        }
        return String.format(STANDARD_STATISTICS_MESSAGE.getMessage(), lottoRank.matchPoint,
                decFormat.format(lottoRank.reward), count);

    }

}
