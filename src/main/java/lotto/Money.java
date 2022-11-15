package lotto;

import static lotto.ExceptionCode.INVALID_MONEY_PER_LOTTO;

public class Money {

    public static final int MONEY_PER_LOTTO = 1_000;

    private final int money;

    public Money(int money) {
        validate(money);
        this.money = money;
    }

    private void validate(int money) {
        if (money < MONEY_PER_LOTTO) {
            throw new IllegalArgumentException(INVALID_MONEY_PER_LOTTO);
        }
    }

    public int getLottoPurchaseAmount() {
        return money / MONEY_PER_LOTTO;
    }
}
