package lotto.domain;

import java.util.regex.Pattern;

import static lotto.constant.ConstValue.DIGIT_REGEX;
import static lotto.constant.ConstValue.PURCHASED_AMOUNT_UNIT;
import static lotto.constant.Message.*;

public class PurchasedAmount {
    private int price;

    public PurchasedAmount(String inputPrice) {
        validate(inputPrice);
        this.price = Integer.parseInt(inputPrice);
    }

    public int getPrice() {
        return price;
    }

    public int getCount() {
        return this.price / PURCHASED_AMOUNT_UNIT;
    }

    private void validate(String inputPrice) {
        /*숫자 검사*/
        validateDigit(inputPrice);
        validateMinimum(inputPrice);
        validateUnit(inputPrice);
    }

    private void validateUnit(String inputPrice) {
        int price = Integer.parseInt(inputPrice);

        if (price % PURCHASED_AMOUNT_UNIT != 0) {
            throw new IllegalArgumentException(ERROR_MESSAGE + INVALID_MONEY_UNIT_INPUT_MESSAGE);
        }
    }

    private void validateMinimum(String inputPrice) {
        int price = Integer.parseInt(inputPrice);

        if (price < PURCHASED_AMOUNT_UNIT) {
            throw new IllegalArgumentException(ERROR_MESSAGE + LESS_THAN_MINIMUM_MONEY_INPUT_MESSAGE);
        }
    }

    private void validateDigit(String inputPrice) {
        if (!Pattern.matches(DIGIT_REGEX, inputPrice)) {
            throw new IllegalArgumentException(ERROR_MESSAGE + INVALID_MONEY_INPUT_FORMAT_MESSAGE);
        }
    }
}
