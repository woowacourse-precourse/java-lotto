package domain;

import util.ExceptionMessage;
import util.LottoRule;

public class Money {

    private final int money;

    public Money(int money) {
        validatePurchaseAmount(money);
        this.money = money;
    }

    private void validatePurchaseAmount(int money) {
        if (money % LottoRule.PURCHASE_UNIT != 0) {
            throw new IllegalArgumentException(ExceptionMessage.REST_EXISTS);
        }
    }

    public int getMoney() {
        return money;
    }

}
