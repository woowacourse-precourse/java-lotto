package lotto.domain;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.RoundingMode;
import java.util.Map;
import java.util.Map.Entry;

public class LottoResultCalculator {

    private LottoResultCalculator() {
    }


    public static BigInteger calculateTotalPrize(Map<Lotto, LottoRank> ranks) {
        BigInteger totalPrize = BigInteger.ZERO;
        for (Entry<Lotto, LottoRank> rank : ranks.entrySet()) {
            if (rank.getValue() == null) {
                continue;
            }
            totalPrize = totalPrize.add(new BigInteger(String.valueOf(rank.getValue().getPrize())));
        }
        return totalPrize;
    }

    public static BigDecimal calculateEarningsRatio(Long totalCost, BigInteger totalPrize) {
        if (totalCost == 0) {
            return BigDecimal.ZERO;
        }
        BigDecimal earning = new BigDecimal(totalPrize);
        BigDecimal price = new BigDecimal(totalCost);
        return earning.multiply(new BigDecimal("100")).divide(price, 1, RoundingMode.HALF_EVEN);
    }

}

