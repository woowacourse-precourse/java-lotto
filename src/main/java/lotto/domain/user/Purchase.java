package lotto.domain.user;

import lotto.common.Constant;
import lotto.exception.InputException;

public class Purchase {

    private final int amount;

    private Purchase(int amount) {
        isDividedByLottoAmount(amount);
        this.amount = amount;
    }

    public static Purchase create(int amount) {
        return new Purchase(amount);
    }

    private static void isDividedByLottoAmount(int purchaseAmount) {
        if (purchaseAmount % Constant.LOTTO_PRICE != 0) {
            throw new IllegalArgumentException(InputException.MONEY_NOT_DIVIDE_BY_LOTTO_UNIT.message());
        }
    }

    public int getLottoPublishCount() {
        return amount / Constant.LOTTO_PRICE;
    }
}
