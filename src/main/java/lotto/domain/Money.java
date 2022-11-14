package lotto.domain;

import static lotto.constant.Constants.ErrorMessage.MAXIMUM_AMOUNT;
import static lotto.constant.Constants.ErrorMessage.MINIMUM_AMOUNT;
import static lotto.constant.Constants.ErrorMessage.NON_UNIT_AMOUNT;

import lotto.constant.Constants;

public class Money {
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
        return 100D * totalPrize / amount;
    }

    private static void validateMinimumAmount(int money) {
        if (money < Constants.Money.MINIMUM_AMOUNT) {
            throw new IllegalArgumentException(MINIMUM_AMOUNT);
        }
    }

    private static void validateMaximumAmount(int money) {
        if (money > Constants.Money.MAXIMUM_AMOUNT) {
            throw new IllegalArgumentException(MAXIMUM_AMOUNT);
        }
    }

    private static void validateUnitAmount(int money) {
        if (money % Constants.Money.UNIT_AMOUNT != 0) {
            throw new IllegalArgumentException(NON_UNIT_AMOUNT);
        }
    }
}