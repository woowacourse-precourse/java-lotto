package lotto.domain;

import java.util.Map;

public class ProfitCalculator {

    public static int calculateTotalProfit(Map<WinningRank, Integer> winLottoCount) {
        int totalProfit = 0;
        for(WinningRank rank : WinningRank.values()){
            totalProfit += winLottoCount.getOrDefault(rank, 0) * rank.getPrizeMoney();
        }
        return totalProfit;
    }
}
