package lotto.domain;

import lotto.util.RankingType;

import java.util.Map;

import static lotto.util.Constants.INIT_PROFIT;

public class Profit {
    private final int investment;
    private int profit = INIT_PROFIT;

    public Profit(Map<RankingType, Integer> countByRankingType, int investment){
        for (RankingType rankingType : countByRankingType.keySet()) {
            updateProfit(rankingType, countByRankingType.get(rankingType));
        }
        this.investment = investment;
    }

    private void updateProfit(RankingType rankingType, int count){
        this.profit += rankingType.getPrizeMoney() * count;
    }

    public double getProfitRate(){
        return ((double)this.profit / this.investment) * 100;
    }

}
