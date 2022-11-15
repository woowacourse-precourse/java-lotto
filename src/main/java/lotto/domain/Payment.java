package lotto.domain;

import lotto.constant.CommonValue;
import lotto.constant.ErrorMessage;
import lotto.utils.Validation;

import static java.lang.Integer.parseInt;

public class Payment {
    private final int amount;

    public Payment(String input) {
        this.amount = validateInput(input);
    }


    private int validateInput(String input) {
        if (!Validation.isInteger(input)) {
            throw new IllegalArgumentException(ErrorMessage.PAYMENT_IS_NOT_NUMBER);
        }
        int amount = parseInt(input);
        if (!isPositiveInteger(amount)) {
            throw new IllegalArgumentException(ErrorMessage.PAYMENT_IS_NOT_POSITIVE_INTEGER);
        }
        if (!isLottoPriceUnit(amount)) {
            throw new IllegalArgumentException(ErrorMessage.PAYMENT_IS_NOT_LOTTO_PRICE_UNIT);
        }
        return amount;
    }

    private boolean isPositiveInteger(int input) {
        return input > 0;
    }

    private boolean isLottoPriceUnit(int input) {
        return input % CommonValue.LOTTO_PRICE == 0;
    }

    public int getAmount() {
        return amount;
    }
}