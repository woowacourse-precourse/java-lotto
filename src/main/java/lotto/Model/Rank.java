package lotto.Model;

import static lotto.View.Variable.No_bonus;
import static lotto.View.Variable.Winning_money;

import java.text.DecimalFormat;
import java.util.Arrays;

public enum Rank {

    Not_winning("0", 0L),
    Three_nbr("3",5_000L),
    Four_nbr("4",50_000L),
    Five_nbr("5",1_500_000L),
    BONUS_MATCH("5",30_000_000L),
    winning("6",2_000_000_000L);


    private final String matchCount;
    private final Long reward;

    Rank(final String matchCount, final Long prizeMoney) {
        this.matchCount = matchCount;
        this.reward = prizeMoney;
    }

    public Long getReward() {
        return reward;
    }

    public static Rank find(final String matchCount) {
        return Arrays.stream(values()).filter(lottoRank -> lottoRank.matchCount.equals(matchCount)).findFirst()
                .orElse(Not_winning);
    }

    public static Rank of(final Rank lottoRank, final Boolean isBonusMatch) {
        if (lottoRank == Five_nbr && isBonusMatch) {
            return BONUS_MATCH;
        }
        return lottoRank;
    }

    public static String createStatisticsForm(final Rank lottoRank, final Long count) {
        DecimalFormat decFormat = new DecimalFormat("###,###");
        if (lottoRank == BONUS_MATCH) {
            return String.format(No_bonus.getMessage(), lottoRank.matchCount,
                    decFormat.format(lottoRank.reward), count);
        }
        return String.format(Winning_money.getMessage(), lottoRank.matchCount,
                decFormat.format(lottoRank.reward), count);

    }
}