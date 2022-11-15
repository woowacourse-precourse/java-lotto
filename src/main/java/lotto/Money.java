package lotto;

import util.InputValidator;

public class Money {
    public static final int UNIT = 1000;
    private int money;

    public Money(int money) {
        InputValidator.validateUnit(money);
        this.money = money;
    }

    public int getMoney() {
        return money;
    }

    public int calculateLottoCount() {
        return money / UNIT;
    }
}
