package lotto.model;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.RoundingMode;
import java.util.Map;

import static lotto.constValue.Constants.ProfitInfo.*;

public class ProfitCalculator {

    public String calculate(int lottoCount, Map<LottoRank, Integer> lottoResultCount) {
        BigDecimal lottoTicketCount = BigDecimal.valueOf(lottoCount);
        BigDecimal purchasedMoney = lottoTicketCount.multiply(BigDecimal.valueOf(THOUSAND_MONEY));
        BigDecimal winningMoneyAmount = getWinningMoneyAmount(lottoResultCount);
        BigDecimal profitBeforeMultiply = winningMoneyAmount.divide(purchasedMoney);
        BigDecimal profit = profitBeforeMultiply.multiply(BigDecimal.valueOf(PERCENT)).setScale(DECIMAL_POINT_FIRST, RoundingMode.HALF_UP);
        return profit.toString();
    }

    public BigDecimal getWinningMoneyAmount(Map<LottoRank, Integer> lottoResultCount) {
        BigDecimal winningMoneyAmount = new BigDecimal(INIT_MONEY);
        for (Map.Entry<LottoRank, Integer> lottoRankEntry : lottoResultCount.entrySet()) {
            LottoRank rank = lottoRankEntry.getKey();
            int winningMoney = rank.getMoney();
            int winningCount = lottoRankEntry.getValue();
            BigDecimal money = BigDecimal.valueOf(winningMoney);
            BigDecimal count = BigDecimal.valueOf(winningCount);
            BigDecimal sum = money.multiply(count);
            winningMoneyAmount = winningMoneyAmount.add(sum);
        }
        return winningMoneyAmount;
    }

}
