package lotto.controller;

import lotto.domain.Money;
import lotto.view.Input;

public class MoneyController {

    public Money getMoney() {
        int number = Input.readNumber();
        return new Money(number);
    }
}
