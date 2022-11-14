package lotto.model;

import java.util.ArrayList;
import java.util.List;
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

    public double getRateOfReturn(long purchaseAmount) {
        return (getTotalReward() / (double) purchaseAmount) * 100;
    }

    public List<LottoRank> getLottoRanksSortedByCount() {
        List<LottoRank> lottoRanks = new ArrayList<>(lottoScore.keySet());

        lottoRanks.sort((lottoRank1, lottoRank2) -> {
            return (int) (lottoRank1.getCount() - lottoRank2.getCount());
        });

        return lottoRanks;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        List<LottoRank> lottoRanks = getLottoRanksSortedByCount();

        for (LottoRank lottoRank : lottoRanks) {
            if (lottoRank.equals(LottoRank.NONE)) {
                continue;
            }

            stringBuilder.append(lottoRank)
                         .append(lottoScore.get(lottoRank))
                         .append("개")
                         .append("\n");
        }

        return stringBuilder.toString();
    }
}
