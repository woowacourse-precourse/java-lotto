package lotto;

import lotto.enums.Rank;

import java.util.Arrays;
import java.util.EnumMap;

public class LottoResult {
    private static final int PERCENT_CONVERT_NUMBER = 100;
    private final EnumMap<Rank, Integer> ranks;

    public LottoResult(EnumMap<Rank, Integer> ranks) {
        this.ranks = ranks;
    }

    public float calculateEarningRatio(long buyPrice) {
        float ratio;
        long totalWinning = 0;

        for (Rank rank : Rank.values()) {
            totalWinning = totalWinning + (long)rank.getWinningMoney() * ranks.getOrDefault(rank, 0);
        }
        ratio = PERCENT_CONVERT_NUMBER * (totalWinning / Float.valueOf(buyPrice));

        return ratio;
    }

    public Integer getWinningCount(Rank rank) {
        return this.ranks.getOrDefault(rank, 0);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LottoResult compareResult = (LottoResult) o;

        return Arrays.stream(Rank.values()).allMatch(rank ->
                this.ranks.getOrDefault(rank, 0).equals(compareResult.ranks.getOrDefault(rank, 0)));
    }
}
