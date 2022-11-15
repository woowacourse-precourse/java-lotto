package lotto.domain;

import java.util.Map;

public class Profit {
    public double getProfit(Map<Rank, Integer> totalRank, int money){
        int Profit = 0;
        Rank[] ranks = Rank.values();
        for (Rank rank : ranks){
            Profit += totalRank.get(rank) * rank.getReward();
        }
        return ((double)(Profit / money) * 100.0);
    }
}
