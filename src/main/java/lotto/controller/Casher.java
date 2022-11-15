package lotto.controller;

import static lotto.controller.Constants.*;

public class Casher {

    public static int getTicketNumber(String money) {
        ExceptionHandler.validateMoneyUnit(money);
        return Integer.parseInt(money) / MONEY_UNIT;
    }
}
