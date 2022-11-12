package lotto.domain;

import static lotto.domain.ErrorMessage.LOTTO_PURCHASE_MONEY_ERROR_MESSAGE;

public class LottoPurchaseMoney {
    static final int LOTTO_PRICE = 1000;

    private final int money;

    public LottoPurchaseMoney(int money) {
        validate(money);
        this.money = money;
    }

    private void validate(int money) {
        if (money % LOTTO_PRICE != 0) {
            throw new IllegalArgumentException(LOTTO_PURCHASE_MONEY_ERROR_MESSAGE);
        }
    }

    public int getMoney() {
        return money;
    }
}
