package lotto.domain;

import lotto.utils.ErrorMessage;

public class Money {
    private static final int DIVISIBLE = 0;

    private final int amount;

    public Money(int amount) {
        validateMoney(amount);

        this.amount = amount;
    }

    private static void validateMoney(int amount) {
        if (isMoneyIndivisibleByPrice(amount)) {
            throw new IllegalArgumentException(ErrorMessage.MONEY_LEFT_OVER);
        }
    }

    private static boolean isMoneyIndivisibleByPrice(int amount) {
        return amount % Lotto.PRICE != DIVISIBLE;
    }

    public static Money of(int amount) {
        return new Money(amount);
    }

    public int countAvailable(int price) {
        return amount / price;
    }
}
