package lotto.domain;

import java.util.regex.Pattern;

import static lotto.constant.ConstValue.DIGIT_REGEX;
import static lotto.constant.Message.INVALID_MONEY_INPUT_FORMAT_MESSAGE;

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
            throw new IllegalArgumentException();
        }

        if (!validateUnit(inputPrice)) {
            throw new IllegalArgumentException();
        }
    }

    private boolean validateDigit(String inputPrice) {
        if (!Pattern.matches(DIGIT_REGEX, inputPrice)) {
            return false;
        }
        return true;
    }
}
