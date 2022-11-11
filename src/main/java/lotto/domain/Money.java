package lotto.domain;

import lotto.utils.ExceptionType;
import lotto.view.Output;

public class Money {
    private static final int LOTTO_PRICE = 1000;
    private final int money;

    public Money(int money) {
        validate(money);
        this.money = money;
    }

    private void validate(int money) {
        isLowerThan1000(money);
        isDivideInto1000(money);
    }

    private void isLowerThan1000(int money) {
        if(money < LOTTO_PRICE) {
            Output.printErrorAndExit(ExceptionType.LOWER_THAN_1000.getMessage());
            throw new IllegalArgumentException(ExceptionType.LOWER_THAN_1000.getMessage());
        }
    }

    private void isDivideInto1000(int money) {
        if(money % LOTTO_PRICE != 0) {
            Output.printErrorAndExit(ExceptionType.NOT_DIVISION_INTO_1000.getMessage());
            throw new IllegalArgumentException(ExceptionType.NOT_DIVISION_INTO_1000.getMessage());
        }
    }

    public int getMoney() {
        return money;
    }
}
