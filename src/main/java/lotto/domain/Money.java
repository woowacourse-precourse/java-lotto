package lotto.domain;

import lotto.constants.ErrorMessages;

public class Money {

    private final long money;

    public Money(long money) {
        this.money = money;
        validate();
    }

    private void validate() {
        validateNotNegative();
        validateMultipleOfLottoPrice();
    }

    private void validateNotNegative() {
        if (money < 0) {
            System.out.println(ErrorMessages.MONEY_SIGN);
            throw new IllegalArgumentException();
        }
    }

    private void validateMultipleOfLottoPrice() {
        if (money % Lotto.PRICE != 0) {
            System.out.println(ErrorMessages.MONEY_UNIT);
            throw new IllegalArgumentException();
        }
    }

    public long getMoney() {
        return money;
    }

    public long countPurchasable(int price) {
        return money / price;
    }
}
