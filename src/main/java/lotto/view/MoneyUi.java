package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.domain.Money;
import lotto.service.MoneyService;

import static lotto.service.ExceptionHandler.validateInputtedMoney;
import static lotto.values.Constants.Console.INPUT_MONEY_MESSAGE;

public class MoneyUi {

    public static void printInputMoneyMessage() {
        System.out.println(INPUT_MONEY_MESSAGE);
    }

    public static Money inputMoney() {
        MoneyService moneyService = MoneyService.getMoneyService();

        String money = Console.readLine();
        validateInputtedMoney(money);
        return new Money(moneyService.toInteger(money));
    }
}
