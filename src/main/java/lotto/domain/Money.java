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
        return changeToMoney(money);
    }

    private static Money changeToMoney(String inputtedMoney) {
        validateInputtedMoney(inputtedMoney);
        int money = Integer.parseInt(inputtedMoney);
        return new Money(money);

    }
}
