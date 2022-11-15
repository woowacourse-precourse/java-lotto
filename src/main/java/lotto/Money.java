package lotto;

import static lotto.exception.ExceptionCode.INVALID_MONEY_PER_LOTTO;

public class Money {

    public static final int MONEY_PER_LOTTO = 1_000;

    private final long money;

    public Money(long money) {
        validate(money);
        this.money = money;
    }

    private void validate(long money) {
        if (money < MONEY_PER_LOTTO) {
            throw new IllegalArgumentException(INVALID_MONEY_PER_LOTTO);
        }
        if ((money % MONEY_PER_LOTTO) != 0) {
            throw new IllegalArgumentException(INVALID_MONEY_PER_LOTTO);
        }
    }

    public long getLottoPurchaseAmount() {
        return money / MONEY_PER_LOTTO;
    }

    public double getEarningRate(long reward) {
        return ((double) reward / (double) money) * 100.0;
    }
}
