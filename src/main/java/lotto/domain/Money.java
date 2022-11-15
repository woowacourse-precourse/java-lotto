package lotto.domain;

import lotto.Utils;
import lotto.exception.money.MoneyLessException;
import lotto.exception.money.MoneyUnitWrongException;

public class Money {
    public static final int MONEY_DIVIDE_UNIT = 1000;
    private final int money;

    public Money(String input) {
        this.money = validate(input);
    }

    public int validate(String input) {
        int money = Utils.textToNumber(input);

        if (money < MONEY_DIVIDE_UNIT) {
            throw new MoneyLessException();
        }
        if (money % MONEY_DIVIDE_UNIT != 0) {
            throw new MoneyUnitWrongException();
        }
        return money;
    }

    public int getMoney() {
        return money;
    }

    public int getTicketCount() {
        return money / MONEY_DIVIDE_UNIT;
    }
}
