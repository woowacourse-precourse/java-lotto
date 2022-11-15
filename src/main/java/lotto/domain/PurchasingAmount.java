package lotto.domain;

import static lotto.domain.ErrorMessage.INCORRECT_PURCHASING_AMOUNT;
import static lotto.domain.LottoStatus.PRICE;

public class PurchasingAmount {
    private final int money;

    public PurchasingAmount(int money) {
        validateMonetaryUnit(money);
        this.money = money;
    }

    public int getMoney() {
        return money;
    }

    private void validateMonetaryUnit(int money) {
        if (isDividable(money)) {
            throw new IllegalArgumentException(INCORRECT_PURCHASING_AMOUNT.toString());
        }
    }

    private boolean isDividable(int money) {
        return money < PRICE.getValue() || money % PRICE.getValue() != 0;
    }
}
