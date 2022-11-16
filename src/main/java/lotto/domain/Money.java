package lotto.domain;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Objects;

public class Money {
    public static final Money NONE = from(0);
    private final BigDecimal money;

    public Money(BigDecimal money){
        this.money = money;
    }

    public static Money from(long price){
        return new Money(BigDecimal.valueOf(price));
    }

    public Money divide(Money price){
        return new Money(money.divide(price.money,2, RoundingMode.FLOOR));
    }

    public int intValue(){
        return money.intValue();
    }

    public double doubleValue(){
        return money.doubleValue();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Money money1 = (Money) o;
        return Objects.equals(money, money1.money);
    }

    @Override
    public int hashCode() {
        return Objects.hash(money);
    }
}
