package lotto.domain;

import java.util.List;
import java.util.Map;

public class LottoProfitRate {
    public double calculateProfitRate(List<Lotto> lotteries, Map<LottoRank, Integer> lottoWinAmounts) {
        double buyAmount = lotteries.size() * 1000;
        long lottoProfit = 0;
        for (LottoRank lottoRank : lottoWinAmounts.keySet()) {
            lottoProfit += lottoRank.getRankMoney() * lottoWinAmounts.get(lottoRank);
        }
        double lottoProfitRate = (lottoProfit / buyAmount) * 100;
        return lottoProfitRate;
    }
}
