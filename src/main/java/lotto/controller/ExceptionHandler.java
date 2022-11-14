package lotto.controller;

import static lotto.controller.Constants.*;

public class ExceptionHandler {

    protected static void validateMoneyUnit(int money) {

        String pattern = "^[0-9]*$";
        if (money % MONEY_UNIT != 0 || pattern.matches(Integer.toString(money))) {
            throw new IllegalArgumentException(INPUT_CORRECT_FORMAT_MONEY);
        }
    }
}
