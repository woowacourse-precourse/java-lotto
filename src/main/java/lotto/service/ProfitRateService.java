package lotto.service;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class ProfitRateService {

    private static final String HUNDRED = "100";

    public static BigDecimal calculateRate(int purchaseAmount, double prizeMoney) {
        BigDecimal purchase = new BigDecimal(purchaseAmount);
        BigDecimal prize = new BigDecimal(prizeMoney);

        return prize.multiply(new BigDecimal(HUNDRED)
                    .divide(purchase, 5, RoundingMode.HALF_UP))
                    .setScale(1);
    }
}
