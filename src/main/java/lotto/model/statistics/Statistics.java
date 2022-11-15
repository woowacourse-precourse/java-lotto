package lotto.model.statistics;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.HashMap;
import java.util.Map;

public class Statistics {

    private final Map<Rank, BigDecimal> rankCount = new HashMap<>();
    private BigDecimal prize = new BigDecimal(0);
    private BigDecimal yield = new BigDecimal(0);

    public Statistics(){
        this.rankCount.put(Rank.FIRST,BigDecimal.ZERO);
        this.rankCount.put(Rank.SECOND,BigDecimal.ZERO);
        this.rankCount.put(Rank.THIRD,BigDecimal.ZERO);
        this.rankCount.put(Rank.FOURTH,BigDecimal.ZERO);
        this.rankCount.put(Rank.FIFTH,BigDecimal.ZERO);
        this.rankCount.put(Rank.FAIL,BigDecimal.ZERO);
    }

    public void update(Rank rank){
        updateRankCount(rank);
        setPrize(rank);
    }

    private void updateRankCount(Rank rank){
        BigDecimal count = rankCount.get(rank);
        count = count.add(BigDecimal.ONE);
        rankCount.put(rank,count);
    }

    private void setPrize(Rank rank){
        prize = prize.add(new BigDecimal(rank.getPrize()));
    }

    public void calculateYield(BigDecimal money){
        try {
            yield = prize.divide(money, 3, RoundingMode.HALF_UP).multiply(BigDecimal.valueOf(100));
        }catch (Exception e){
            throw new IllegalArgumentException();
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
