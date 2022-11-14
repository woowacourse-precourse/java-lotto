package lotto.domain;

import java.math.BigDecimal;
import lotto.exception.domain.DivideZeroException;
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
        validateNotZero(investmentPrincipalMoney);
        return calculateYield(new BigDecimal(investmentPrincipalMoney.money), new BigDecimal(revenueMoney.money));
    }

    private static double calculateYield(BigDecimal investmentPrincipal, BigDecimal revenue) {
        return revenue.divide(investmentPrincipal).multiply(HUNDRED_BIG_DECIMAL).doubleValue();
    }

    public int divideValue(Money money) {
        validateNotZero(money);
        return Long.valueOf(this.money / money.money).intValue();
    }

    private static void validateNotZero(Money money) {
        if (money.money == 0) {
            throw new DivideZeroException();
        }
    }

    public Money add(Money money) {
        return new Money(this.money + money.money);
    }

    public boolean notZero() {
        return this.money != 0;
    }

    public long value() {
        return this.money;
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
}
