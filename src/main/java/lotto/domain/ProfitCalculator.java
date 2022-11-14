package lotto.domain;

public class ProfitCalculator {
    private int profit = 0;

    public void updateProfit(RankingType rankingType){
        profit += rankingType.getPrizeMoney();
    }

    public int getProfitRate(int investment){
        return profit / investment;
    }

}
