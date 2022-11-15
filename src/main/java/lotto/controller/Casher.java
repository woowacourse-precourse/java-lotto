package lotto.controller;

import static lotto.controller.Constants.*;

public class Casher {

    public static int calculateTicketsNumber(int money) {
        ExceptionHandler.validateMoneyUnit(money);
        return money / MONEY_UNIT;
    }
}
