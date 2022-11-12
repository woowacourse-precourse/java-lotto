package lotto.domain;

import java.math.BigDecimal;
import java.util.Objects;
import lotto.exception.domain.MoneyMinimumException;

public class Money {
    private static final long MONEY_MIN = 1;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Money money1 = (Money) o;
        return money == money1.money;
    }

    @Override
    public int hashCode() {
        return Objects.hash(money);
    }
}
