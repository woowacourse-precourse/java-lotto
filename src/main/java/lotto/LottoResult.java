package lotto;

import lotto.type.Rank;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.EnumMap;

public class LottoResult {
    EnumMap<Rank, Integer> ranks;

    public LottoResult(EnumMap<Rank, Integer> ranks) {
        this.ranks = ranks;
    }

    public float calculateEarningRatio(Integer buyPrice) {
        float ratio;
        BigInteger totalWinning = new BigInteger("0");

        for (Rank rank : Rank.values()) {
            totalWinning = totalWinning.add(BigInteger.valueOf(rank.getWinningMoney() * ranks.getOrDefault(rank, 0)));
        }

        ratio = totalWinning.divide(BigInteger.valueOf(buyPrice))
                .floatValue();

        return ratio;
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
