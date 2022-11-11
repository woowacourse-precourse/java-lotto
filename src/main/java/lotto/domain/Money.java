package lotto.domain;

import static lotto.utils.Constant.LOTTO_PRICE;

import lotto.utils.ExceptionType;
import lotto.view.Output;

public class Money {
    private final int money;

    public Money(int money) {
        validate(money);
        this.money = money;
    }

    private void validate(int money) {
        isLowerThanLottoPrice(money);
        isDivideIntoLottoPrice(money);
    }

    private void isLowerThanLottoPrice(int money) {
        if(money < LOTTO_PRICE) {
            Output.printErrorAndExit(ExceptionType.LOWER_THAN_LOTTO_PRICE.getMessage());
            throw new IllegalArgumentException(ExceptionType.LOWER_THAN_LOTTO_PRICE.getMessage());
        }
    }

    private void isDivideIntoLottoPrice(int money) {
        if(money % LOTTO_PRICE != 0) {
            Output.printErrorAndExit(ExceptionType.NOT_DIVISION_INTO_LOTTO_PRICE.getMessage());
            throw new IllegalArgumentException(ExceptionType.NOT_DIVISION_INTO_LOTTO_PRICE.getMessage());
        }
    }

    public int getMoney() {
        return money;
    }
}
