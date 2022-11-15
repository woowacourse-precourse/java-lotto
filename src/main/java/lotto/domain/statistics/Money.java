package lotto.domain.statistics;

import java.text.DecimalFormat;

public class Money {

    DecimalFormat decFormat = new DecimalFormat("###,###");

    private final int MONEY_UNIT = 1000;
    private final int amount;

    private Money(int moneyAmount) {
        validate(moneyAmount);
        this.amount = moneyAmount;
    }

    public static Money from(int moneyAmount) {
        return new Money(moneyAmount);
    }

    private void validate(int moneyAmount) {
        if (moneyAmount % MONEY_UNIT != 0) {
            throw new IllegalArgumentException(
                String.format("[ERROR] 구입 금액은 1000원 단위여야만 합니다. : %d", moneyAmount));
        }
    }

    public int getLottoCnt() {
        return amount / MONEY_UNIT;
    }

    public int get() {
        return amount;
    }

    @Override
    public String toString() {
        return decFormat.format(amount);
    }

}
