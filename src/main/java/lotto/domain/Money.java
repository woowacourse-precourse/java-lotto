package lotto.domain;

import static lotto.util.ExceptionHandler.validateMoney;

public class Money {
    private final int money;

    public Money(int money) {
        validateMoney(money);
        this.money = money;
    }

    public int getMoney() {
        return money;
    }

}
