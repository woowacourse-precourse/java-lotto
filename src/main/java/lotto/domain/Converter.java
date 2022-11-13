package lotto.domain;

import static lotto.domain.ErrorMessage.INPUT_EMPTY_ERROR;
import static lotto.domain.ErrorMessage.MONEY_LIMIT_ERROR;
import static lotto.domain.ErrorMessage.MONEY_NUMBER_ERROR;

public class Converter {
    public static int changeToMoney(String input) {
        if (InputValidator.isEmpty(input)) {
            throw new IllegalArgumentException(INPUT_EMPTY_ERROR.toString());
        }
        if (!InputValidator.isNumber(input)) {
            throw new IllegalArgumentException(MONEY_NUMBER_ERROR.toString());
        }
        if (!InputValidator.isInLimit(input)) {
            throw new IllegalArgumentException(MONEY_LIMIT_ERROR.toString());
        }
        return  Integer.parseInt(input);
    }
}