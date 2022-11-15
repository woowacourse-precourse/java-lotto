package lotto.domain;

import lotto.exception.IllegalArgumentError;
import lotto.util.Constants;

public class Money {

    private final int money;

    public Money(int money) {
        validateMoney(money);
        this.money = money;
    }

    public void validateMoney(int money) {
        if (money % Constants.ONE_TICKET_PRICE != 0) {
            throw new IllegalArgumentError("invalid money");
        }
    }

    public int getMoney() {
        return money;
    }


}
