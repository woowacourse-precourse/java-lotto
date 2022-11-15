package lotto.view;

import static camp.nextstep.edu.missionutils.Console.readLine;

import lotto.controller.ExceptionHandler;

public class MoneyReceiver {

    public static String receiveMoney() {
        String money = readLine();
        ExceptionHandler.validateMoneyUnit((money));
        return money;
    }
}
