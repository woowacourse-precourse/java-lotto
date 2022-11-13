package lotto.domain;

import java.util.regex.Pattern;

import static lotto.constant.ConstValue.DIGIT_REGEX;
import static lotto.constant.ConstValue.PURCHASED_AMOUNT_UNIT;
import static lotto.constant.Message.INVALID_MONEY_INPUT_FORMAT_MESSAGE;
import static lotto.constant.Message.LESS_THAN_MINIMUM_MONEY_INPUT_MESSAGE;

public class PurchasedAmount {
    private int price;

    public PurchasedAmount(String inputPrice) {
        validate(inputPrice);
        this.price = Integer.parseInt(inputPrice);
    }

    private void validate(String inputPrice) {
        /*숫자 검사*/
        if (!validateDigit(inputPrice)) {
            throw new IllegalArgumentException(INVALID_MONEY_INPUT_FORMAT_MESSAGE);
        }

        if (!validateMinimum(inputPrice)) {
            throw new IllegalArgumentException(LESS_THAN_MINIMUM_MONEY_INPUT_MESSAGE);
        }

        if (!validateUnit(inputPrice)) {
            throw new IllegalArgumentException();
        }
    }

    private boolean validateMinimum(String inputPrice) {
        int price = Integer.parseInt(inputPrice);

        if (price < PURCHASED_AMOUNT_UNIT) {
            return false;
        }
        return true;
    }

    private boolean validateDigit(String inputPrice) {
        if (!Pattern.matches(DIGIT_REGEX, inputPrice)) {
            return false;
        }
        return true;
    }
}
