package lotto.model;

import lotto.util.InputVerifier;
import lotto.view.View;

/*
 * 로또 구입 금액을 의미하는 객체
 */

public class Money {

    private final int money;

    public Money(int money) {
        validatePrice(money);
        this.money = money;
    }

    public int getMoney() {
        return this.money;
    }

    private void validatePrice(int money) {
        if (!InputVerifier.isLottoPrice(money)) {
            View.printNotLottoPrice();
            throw new IllegalArgumentException();
        }
    }

}
