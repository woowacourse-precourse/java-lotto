package lotto.domain;

import java.text.DecimalFormat;
import java.util.Objects;

public class Money {

    public static final int UNIT = 1000;
    private static final String ERROR_UNIT = String.format("금액은 %d 단위만 입력 가능합니다.", UNIT);
    private static final String ERROR_NEGATIVE = "금액은 음수 입력이 불가능합니다.";

    private static final DecimalFormat decimalFormat = new DecimalFormat("###,###");
    private final int money;

    public Money(int money) {
        validateNegative(money);
        validateMoneyUnit(money);
        this.money = money;
    }

    private void validateMoneyUnit(int money) {
        if (money % UNIT != 0 || money == 0) {
            throw new IllegalArgumentException(ERROR_UNIT);
        }
    }

    private void validateNegative(int money) {
        if (money < 0) {
            throw new IllegalArgumentException(ERROR_NEGATIVE);
        }
    }

    public String getMoneyFormat() {
        return decimalFormat.format(money);
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

    public int intValue() {
        return money;
    }
}
