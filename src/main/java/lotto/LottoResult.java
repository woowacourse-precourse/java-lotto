package lotto;

import lotto.type.Rank;

import java.math.BigInteger;
import java.util.List;

public class LottoResult {
    List<Rank> ranks;

    public LottoResult(List<Rank> ranks) {
        this.ranks = ranks;
    }

    public float calculateEarningRatio(Integer buyPrice) {
        float ratio;
        BigInteger totalWinning = new BigInteger("0");

        for (Rank rank : ranks) {
            totalWinning = totalWinning.add(BigInteger.valueOf(rank.getWinningMoney()));
        }
        ratio = totalWinning.divide(BigInteger.valueOf(buyPrice))
                .floatValue();

        return ratio;
    }
}
