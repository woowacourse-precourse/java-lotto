package lotto.model;

import lotto.util.Validator;

public class Money {
    private int money;
    private Validator validator = new Validator();

    public Money(int money) {
        validator.validateUnit(money);
        this.money = money;
    }

    public int getMoney() {
        return this.money;
    }
}
