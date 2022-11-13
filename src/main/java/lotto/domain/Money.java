package lotto.domain;

import static lotto.utils.ErrorMessages.MONEY_NOT_INTEGER;

public class Money {
    private final int money;

    public Money(String money) {
        validateInteger(money);
        this.money = Integer.parseInt(money);
    }

    private void validateInteger(String money) {
        try {
            Integer.parseInt(money);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(MONEY_NOT_INTEGER);
        }
    }
}
