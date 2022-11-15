package lotto.domain;

import static lotto.utils.Constant.LOTTO_PRICE;

public class Money {
    private final int money;

    public Money(int money) {
        this.money = money;
    }

    public int getMoney() {
        return this.money;
    }

    public int calculateLottoAmount() {
        return this.money / LOTTO_PRICE;
    }
}
