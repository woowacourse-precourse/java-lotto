package lotto.domain;

import lotto.utils.Validation;
import lotto.views.InputView;

public class Money {
    public static final int LOTTO_PRICE = 1000;
    private int money;

    public Money(int money) {
        Validation.validateMoney(money);
        this.money = money;
    }

    public int purchase() {
        InputView.showNumberOfLottos(this.money, LOTTO_PRICE);
        return this.money / LOTTO_PRICE;
    }
}
