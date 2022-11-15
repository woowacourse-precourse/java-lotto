package lotto.view.controller;

import camp.nextstep.edu.missionutils.Console;

import java.util.List;

import static lotto.utils.ScoreUtil.calRateOfReturnMessage;
import static lotto.view.controller.ConsoleMessage.INPUT_BUY_MONEY;
import static lotto.view.vlidation.InputMoneyValidator.validate;

public class MoneyView {
    private MoneyView() {
    }

    public static Integer inputMoneyNumber() {
        System.out.println(INPUT_BUY_MONEY.getMessage());
        String money = Console.readLine();
        validate(money);
        return Integer.valueOf(money);
    }

    public static void printRateOfReturn(List<Integer> scoreBoard) {
        String rateOfReturnMessage = calRateOfReturnMessage(scoreBoard);
        System.out.println(rateOfReturnMessage);

    }
}
