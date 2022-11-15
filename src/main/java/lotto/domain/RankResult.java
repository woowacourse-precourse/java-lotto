package lotto.domain;

import java.math.BigDecimal;
import java.util.Map;

public class RankResult {
    private final Map<Rank, Integer> rankResult;

    public RankResult(Map<Rank, Integer> rankResult) {
        this.rankResult = rankResult;
    }

    public BigDecimal yield() {
        return calculateYield(rankResult);
    }

    private BigDecimal calculateYield(Map<Rank, Integer> rankResult) {
        return BigDecimal.valueOf((totalReward(rankResult) / (buyTicket(rankResult) * LottoGame.TicketPrice)) * 100.0);
    }

    private double buyTicket(Map<Rank, Integer> rankResult) {
        return rankResult.values().stream()
                .mapToDouble(Integer::intValue)
                .reduce(Double::sum)
                .orElseThrow();
    }

    private double totalReward(Map<Rank, Integer> rankResult) {
        return rankResult.entrySet().stream()
                .map(rankIntegerEntry -> Integer.parseInt(removeRest(rankIntegerEntry)) * rankIntegerEntry.getValue())
                .mapToDouble(Integer::intValue)
                .reduce(Double::sum)
                .orElse(0);
    }

    private static String removeRest(Map.Entry<Rank, Integer> rankIntegerEntry) {
        return String.join("", rankIntegerEntry.getKey().getReward().split(","));
    }

    public Map<Rank, Integer> getRankResult() {
        return rankResult;
    }
}
