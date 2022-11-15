package lotto.domain.validator;

import lotto.domain.constants.ErrorMessage;
import lotto.domain.constants.LottoRule;

public class MoneyValidator {
    private MoneyValidator() { }

    public static void validatePayment(int payment) {
        validateMoneyValue(payment);
        if (isLessThanLottoPrice(payment)) {
            throw new IllegalArgumentException(ErrorMessage.PAYMENT_INSUFFICIENT.getValue());
        }
        if (hasRemainderForLottoPrice(payment)) {
            throw new IllegalArgumentException(ErrorMessage.PAYMENT_HAS_REMAINDER.getValue());
        }
    }

    public static void validateMoneyValue(int money) {
        if (isNegative(money)) {
            throw new IllegalArgumentException(ErrorMessage.MONEY_NEGATIVE.getValue());
        }
    }

    private static boolean isNegative(int money) {
        return money < 0;
    }

    private static boolean isLessThanLottoPrice(int money) {
        return money < LottoRule.PRICE.getValue();
    }

    private static boolean hasRemainderForLottoPrice(int money) {
        return (money % (LottoRule.PRICE.getValue())) != 0;
    }
}
