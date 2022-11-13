package lotto.controller;

import static lotto.utils.Converter.stringToInt;

import lotto.domain.Money;
import lotto.view.Input;

public class MoneyController {

    public Money getMoney() {
        String line = Input.readLine();
        int convertedLine = stringToInt(line);
        return new Money(convertedLine);
    }
}
