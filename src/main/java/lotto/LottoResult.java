package lotto;

import lotto.type.Rank;

import java.util.Arrays;
import java.util.EnumMap;

public class LottoResult {
    EnumMap<Rank, Integer> ranks;

    public LottoResult(EnumMap<Rank, Integer> ranks) {
        this.ranks = ranks;
    }

    public float calculateEarningRatio(Integer buyPrice) {
        float ratio;
        Long totalWinning = (long)0;

        for (Rank rank : Rank.values()) {
            totalWinning = totalWinning + Long.valueOf(rank.getWinningMoney()) * ranks.getOrDefault(rank, 0);
        }
        System.out.println(totalWinning);
        ratio = 100 * (totalWinning / (Float.valueOf(buyPrice)));

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
                this.ranks.get(rank).equals(compareResult.ranks.get(rank)));
    }
}
