package lotto.view.controller;

import camp.nextstep.edu.missionutils.Console;

import static lotto.view.vlidation.InputMoneyValidator.validate;

public class MoneyView {
    private MoneyView() {
    }

    public static Integer inputMoneyNumber() {
        System.out.println(ConsoleMessage.INPUT_BUY_MONEY);
        String money = Console.readLine();
        validate(money);
        return Integer.valueOf(money);
    }
}
