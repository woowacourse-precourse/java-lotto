package lotto.service;

import static lotto.view.InputView.inputMoney;

import lotto.domain.Money;

public class MoneyService {

    public static Money createMoney() {
        int money = inputMoney();
        return new Money(money);
    }
}
