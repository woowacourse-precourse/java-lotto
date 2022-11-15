package lotto.model;

import lotto.util.Validator;
import lotto.view.View;

/*
 * 로또 구입 금액을 의미하는 객체
 */

public class Money {

    private final int money;
    private static final int ZERO = 0;

    public Money(int money) {
        validatePurchase(money);
        validatePrice(money);
        this.money = money;
    }

    public int getMoney() {
        return this.money;
    }

    private void validatePurchase(int money) {
        if (money == ZERO) {
            View.printNotPurchase();
            throw new IllegalArgumentException();
        }
    }

    private void validatePrice(int money) {
        if (!Validator.isLottoPrice(money)) {
            View.printNotLottoPrice();
            throw new IllegalArgumentException();
        }
    }

}
