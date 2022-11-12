package lotto.domain;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Map;

public class RankResult {
    public BigDecimal getYield(Map<Rank, Integer> rankResult) {
        return getBigDecimal(rankResult);
    }

    private BigDecimal getBigDecimal(Map<Rank, Integer> rankResult) {
        return BigDecimal.valueOf((totalReward(rankResult) / (buyTicket(rankResult) * 1000.0)) * 100.0);
    }

    private double buyTicket(Map<Rank, Integer> rankResult) {
        return rankResult.values().stream()
                .mapToDouble(Integer::intValue)
                .reduce(Double::sum).orElseThrow();
    }

    private double totalReward(Map<Rank, Integer> rankResult) {
        return rankResult.entrySet().stream()
                .map(rankIntegerEntry -> rankIntegerEntry.getKey().getReward() * rankIntegerEntry.getValue())
                .mapToDouble(Integer::intValue)
                .reduce(Double::sum)
                .orElse(0);
    }
}
