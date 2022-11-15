package lotto.domain;

import static lotto.service.ExceptionHandler.validateMoney;

public class Money {
    private int money;

    public Money(int money) {
        validateMoney(money);
        this.money = money;
    }

    public int getMoney() {
        return money;
    }

}
