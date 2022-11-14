package lotto.domain;

import static java.lang.Math.round;

import java.util.Map;
import java.util.Map.Entry;

public class LottoResultCalculator {

    private LottoResultCalculator() {

    }


    public static Long calculatePrize(Map<Lotto, LottoRank> ranks) {
        Long totalPrize = 0L;
        for (Entry<Lotto, LottoRank> rank : ranks.entrySet()) {
            if (rank.getValue() == null) {
                continue;
            }
            totalPrize += rank.getValue().getPrize();
        }
        return totalPrize;
    }

    public static Double calculateEarningsRatio(Long totalCost, Long totalPrize) {
        if (totalCost == 0) {
            return 0.0d;
        }
        return round(((double) totalPrize / totalCost) * 100 * 10) / 10d;
    }

}

