package lotto.controller;

import static lotto.viewer.ErrorMessage.*;

import java.util.function.Predicate;

public class Money {
    private final int money;

    public Money(String money) throws IllegalArgumentException {
        validateNumber(money);
        int purchaseMoney = Integer.parseInt(money);
        validateDividable(purchaseMoney);
        this.money = purchaseMoney;
    }
    public int calculatePurchaseNumber() {
        return money/1000;
    }

    private void validateDividable(int money) throws IllegalArgumentException {
        if (money%1000 != 0) {
            throw new IllegalArgumentException(UNIT_THOUSANDS);
        }
    }

    private void validateNumber(String money) throws IllegalArgumentException {
        Boolean hasNoneDigit = money.chars()
                .mapToObj(e->(char)e)
                .anyMatch(Predicate.not(Character::isDigit));
        if (hasNoneDigit) {
            throw new IllegalArgumentException(ENTER_NUMBER);
        }
    }

    public static Money from(String money) {
        return new Money(money);
    }
}
