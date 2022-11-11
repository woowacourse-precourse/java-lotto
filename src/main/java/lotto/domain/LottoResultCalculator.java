package lotto.domain;

import java.util.Map;
import java.util.Map.Entry;

public class LottoResultCalculator {
    public static Long calculatePrize(Map<LottoRank, Integer> ranks) {
        Long totalPrize = 0L;
        for (Entry<LottoRank, Integer> entry : ranks.entrySet()) {
            totalPrize += ((long) entry.getKey().getPrize() * entry.getValue());
        }
        return totalPrize;
    }

    public static Double calculateEarningsRatio(Long totalCost, Long prize) {
        if (totalCost == 0) {
            return 0.0d;
        }
        return ((double) prize / totalCost) * 100;
    }

}
