package lotto.controller;

import static lotto.controller.Constants.*;

public class Casher {

    public static int issueTickets(int money) {
        ExceptionHandler.validateMoneyUnit(money);
        return money / MONEY_UNIT;
    }
}
