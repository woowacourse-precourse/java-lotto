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
            System.out.println(LOTTO_PURCHASE_MONEY_ERROR_MESSAGE);
            throw new IllegalArgumentException();
        }
    }

    public int getMoney() {
        return money;
    }
}
