package lotto.domain;

import static lotto.constant.Constants.ErrorMessage.OVER_MAXIMUM_AMOUNT;
import static lotto.constant.Constants.ErrorMessage.LESS_MINIMUM_AMOUNT;
import static lotto.constant.Constants.ErrorMessage.NON_UNIT_AMOUNT;
import static lotto.constant.Constants.Money.MAXIMUM_AMOUNT;
import static lotto.constant.Constants.Money.MINIMUM_AMOUNT;

import lotto.constant.Constants;

public class Money {
    public static final double HUNDRED = 100D;
    private final int amount;

    public Money(int amount) {
        validateMinimumAmount(amount);
        validateMaximumAmount(amount);
        validateUnitAmount(amount);
        this.amount = amount;
    }

    public int calculateQuantity() {
        return amount / Constants.Money.UNIT_AMOUNT;
    }

    public double calculateYield(long totalPrize) {
        return HUNDRED * totalPrize / amount;
    }

    private static void validateMinimumAmount(int money) {
        if (money < MINIMUM_AMOUNT) {
            throw new IllegalArgumentException(LESS_MINIMUM_AMOUNT);
        }
    }

    private static void validateMaximumAmount(int money) {
        if (money > MAXIMUM_AMOUNT) {
            throw new IllegalArgumentException(OVER_MAXIMUM_AMOUNT);
        }
    }

    private static void validateUnitAmount(int money) {
        if (money % Constants.Money.UNIT_AMOUNT != 0) {
            throw new IllegalArgumentException(NON_UNIT_AMOUNT);
        }
    }
}