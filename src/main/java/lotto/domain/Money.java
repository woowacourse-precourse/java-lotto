package lotto.domain;

import java.math.BigDecimal;
import lotto.exception.domain.MoneyMinimumException;

public class Money {
    private static final long MONEY_MIN = 0;
    private static final BigDecimal HUNDRED_BIG_DECIMAL = new BigDecimal(100);

    private final long money;

    public Money(long money) {
        validateMinimum(money);
        this.money = money;
    }

    private void validateMinimum(long money) {
        if (money < MONEY_MIN) {
            throw new MoneyMinimumException(MONEY_MIN);
        }
    }

    public static double yield(Money investmentPrincipalMoney, Money revenueMoney) {
        return calculateYield(new BigDecimal(investmentPrincipalMoney.money), new BigDecimal(revenueMoney.money));
    }

    private static double calculateYield(BigDecimal investmentPrincipal, BigDecimal revenue) {
        return revenue.divide(investmentPrincipal).multiply(HUNDRED_BIG_DECIMAL).doubleValue();
    }

    public int divide(Money lottoPrice) {
        return Long.valueOf(this.money / lottoPrice.money).intValue();
    }
}
