package lotto.model.statistics;

import lotto.utils.ErrorMessage;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.LinkedHashMap;
import java.util.Map;

public class Statistics {

    private final Map<Rank, BigDecimal> rankCount = new LinkedHashMap<>();
    private BigDecimal prize = new BigDecimal(0);
    private BigDecimal yield = new BigDecimal(0);

    public Statistics() {
        this.rankCount.put(Rank.FIFTH, BigDecimal.ZERO);
        this.rankCount.put(Rank.FOURTH, BigDecimal.ZERO);
        this.rankCount.put(Rank.THIRD, BigDecimal.ZERO);
        this.rankCount.put(Rank.SECOND, BigDecimal.ZERO);
        this.rankCount.put(Rank.FIRST, BigDecimal.ZERO);
    }

    public void update(Rank rank) {
        updateRankCount(rank);
        setPrize(rank);
    }

    private void updateRankCount(Rank rank) {
        BigDecimal count = rankCount.get(rank);
        count = count.add(BigDecimal.ONE);
        rankCount.put(rank, count);
    }

    private void setPrize(Rank rank) {
        prize = prize.add(new BigDecimal(rank.getPrize()));
    }

    public void calculateYield(BigDecimal money) {
        try {
            yield = prize.divide(money).multiply(BigDecimal.valueOf(100)).setScale(1, RoundingMode.HALF_UP);
        } catch (Exception e) {
            throw new IllegalArgumentException(ErrorMessage.CANNOT_CALCULATE_YIELD.message);
        }
    }

    public Map<Rank, BigDecimal> getRankCount() {
        return rankCount;
    }

    public BigDecimal getPrize() {
        return prize;
    }

    public BigDecimal getYield() {
        return yield;
    }
}
