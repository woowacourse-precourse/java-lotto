package lotto.model;

import static lotto.exception.MoneyException.isDivideByThousand;
import static lotto.exception.MoneyException.isPositive;
import static lotto.exception.MoneyException.isValidMoneyType;

public class Money {
    private final int money;

    public Money(String money) {
        isValidMoneyType(money);
        isPositive(money);
        isDivideByThousand(money);
        this.money = Integer.parseInt(money);
    }

    public int getMoney() {
        return money;
    }

    public int calculateLottoCount(Money unit) {
        return this.money / unit.money;
    }
}
