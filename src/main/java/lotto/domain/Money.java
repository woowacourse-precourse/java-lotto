package lotto.domain;

import camp.nextstep.edu.missionutils.Console;

import static lotto.util.ExceptionHandler.validateInputtedMoney;
import static lotto.util.ExceptionHandler.validateMoney;

public class Money {
    private int money;

    public Money(int money) {
        validateMoney(money);
        this.money = money;
    }

    public int getMoney() {
        return money;
    }

    public static Money inputMoney() {
        String money = Console.readLine();
        validateInputtedMoney(money);
        return new Money(toInteger(money));
    }

    private static int toInteger(String inputtedMoney) {
        return Integer.parseInt(inputtedMoney);
    }
}
