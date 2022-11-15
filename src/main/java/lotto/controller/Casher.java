package lotto.controller;

import static lotto.controller.Constants.*;

public class Casher {

    public static int calculateTicketsNumber(String money) {
        ExceptionHandler.validateMoneyUnit(money);
        return Integer.parseInt(money) / MONEY_UNIT;
    }
}
