package lotto.domain;

import static lotto.support.ErrorMessage.NEGATIVE_MONEY_ERROR;
import static lotto.support.ErrorMessage.NOT_DIVIDED_BY_LOTTO_PRICE_ERROR;

public class Money {

    private static final int LOTTO_PRICE = 1000;

    private final int money;

    public Money(int money) {
        validateMoney(money);
        this.money = money;
    }

    private void validateMoney(int money) {
        validateDividedByLottoPrice(money);
        validateNotNegative(money);
    }

    private void validateNotNegative(int money) {
        if (money < 0) {
            throw new IllegalArgumentException(NEGATIVE_MONEY_ERROR);
        }
    }

    private void validateDividedByLottoPrice(int money) {
        if (money % LOTTO_PRICE != 0) {
            throw new IllegalArgumentException(NOT_DIVIDED_BY_LOTTO_PRICE_ERROR);
        }
    }

    public int getTicketCount() {
        return money / LOTTO_PRICE;
    }

    public int getMoney() {
        return money;
    }
}
