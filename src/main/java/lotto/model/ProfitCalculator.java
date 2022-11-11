package lotto.model;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.RoundingMode;
import java.util.Map;

public class ProfitCalculator {

    public String calculate(int lottoCount, Map<LottoRank, Integer> lottoResultCount) {
        BigDecimal count = BigDecimal.valueOf(lottoCount);
        BigDecimal purchaseMoney = count.multiply(BigDecimal.valueOf(1000));
        BigDecimal winningMoneyAmount = getWinningMoneyAmount(lottoResultCount);
        BigDecimal profit = winningMoneyAmount.divide(purchaseMoney);
        profit = profit.multiply(BigDecimal.valueOf(100)).setScale(1,RoundingMode.HALF_UP);
        return profit.toString();
    }

    public BigDecimal getWinningMoneyAmount(Map<LottoRank, Integer> lottoResultCount) {
//        double result = 0;
        BigDecimal result = new BigDecimal(0);
        for (Map.Entry<LottoRank, Integer> lottoRankEntry : lottoResultCount.entrySet()) {
            LottoRank rank = lottoRankEntry.getKey();
            int winningMoney =  rank.getMoney();
            int winningCount = lottoRankEntry.getValue();
            BigDecimal money = BigDecimal.valueOf(winningMoney);
            BigDecimal count = BigDecimal.valueOf(winningCount);
            BigDecimal sum = money.multiply(count);
            result = result.add(sum);
        }
        return result;
    }

}
