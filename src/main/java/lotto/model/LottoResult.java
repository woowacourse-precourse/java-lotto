package lotto.model;

import java.util.Map;

public class LottoResult {

    private final Map<LottoRank, Integer> lottoScore;

    public LottoResult(Map<LottoRank, Integer> lottoScore) {
        this.lottoScore = lottoScore;
    }

    public long getTotalReward() {
        long sum = 0L;

        for (LottoRank lottoRank : lottoScore.keySet()) {
            if (lottoRank.equals(LottoRank.NONE)) {
                continue;
            }

            if (lottoScore.get(lottoRank) > 0) {
                sum += lottoRank.getReward() * lottoScore.get(lottoRank);
            }
        }

        return sum;
    }

    public double getRateOfReturn(int purchaseAmount) {
        return Math.round((getTotalReward() / (double) purchaseAmount) * 100 / 10.0);
    }
}
