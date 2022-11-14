package lotto.domain;

import java.util.Map;
import java.util.Map.Entry;

public class LottoResult {
    private final Map<Rank, Integer> lottoResult;

    public LottoResult(Map<Rank, Integer> lottoResult) {
        this.lottoResult = lottoResult;
        this.lottoResult.remove(Rank.LOSE);
    }

    public Map<Rank, Integer> getLottoResult() {
        return this.lottoResult;
    }

    public double getTotalPrize() {
        double totalPrize = 0;
        for (Entry<Rank, Integer> rank : lottoResult.entrySet()) {
            String stripedPrize = rank.getKey().prize().replaceAll(",", "");
            totalPrize += Integer.parseInt(stripedPrize) * rank.getValue();
        }
        return totalPrize;
    }
}
