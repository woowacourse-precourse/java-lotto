package lotto.domain;


import lotto.domain.lotto.correctLotto.Ranking;
import lotto.domain.lotto.correctLotto.Rankings;

public class Result {

    private final long revenue;
    private final double yield;

    public Result(Rankings rankings, Money money) {
        this.revenue = this.calculateRevenue(rankings);
        this.yield = this.calculateYield(money);
    }

    public long getRevenue() {
        return revenue;
    }

    public double getYield() {
        return yield;
    }

    private Long calculateRevenue(Rankings rankings) {
        Long revenue = 0L;
        for (Ranking ranking : rankings.getRankings()) {
            revenue += ranking.getReward();
        }
        return revenue;
    }

    private double calculateYield(Money money) {
        double beforeRound = (double) (this.revenue * 100) / money.getInitialMoney();
        return Math.round((beforeRound) * 10) / 10.0;
    }

}
