package lotto.domain.model;

import static lotto.domain.view.IOMessage.OUTPUT_BONUS_STATISTICS;
import static lotto.domain.view.IOMessage.OUTPUT_STANDARD_STATISTICS;

import java.text.DecimalFormat;
import java.util.Arrays;

public enum LottoRank {

    NO_MATCH("0", 0L),
    THREE_MATCHES("3",5_000L),
    FOUR_MATCHES("4",50_000L),
    FIVE_MATCHES("5",1_500_000L),
    FIVE_BONUS_MATCHES("5",30_000_000L),
    SIX_MATCHES("6",2_000_000_000L);


    private final String matchCount;
    private final Long reward;

    LottoRank(final String matchCount, final Long prizeMoney) {
        this.matchCount = matchCount;
        this.reward = prizeMoney;
    }

    public Long getReward() {
        return reward;
    }

    public static LottoRank find(String matchCount) {
        return Arrays.stream(values()).filter(lottoRank -> lottoRank.matchCount.equals(matchCount)).findFirst()
                .orElse(NO_MATCH);
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
            return String.format(OUTPUT_BONUS_STATISTICS.getMessage(), lottoRank.matchCount,
                    decFormat.format(lottoRank.reward), count);
        }
        return String.format(OUTPUT_STANDARD_STATISTICS.getMessage(), lottoRank.matchCount,
                decFormat.format(lottoRank.reward), count);

    }

}
