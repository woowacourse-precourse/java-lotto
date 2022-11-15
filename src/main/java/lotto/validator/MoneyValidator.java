package lotto.validator;

import static lotto.constants.LottoConstant.LOTTO_PRICE;
import static lotto.validator.ErrorMessages.INVALID_PAID_MONEY_ERROR_MESSAGE;

public class MoneyValidator {
    public static void hasValidUnit(int paidMoney) throws IllegalArgumentException {
        if (!(paidMoney % LOTTO_PRICE == 0)) {
            throw new IllegalArgumentException(INVALID_PAID_MONEY_ERROR_MESSAGE);
        }
    }
}
