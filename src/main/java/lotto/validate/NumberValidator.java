package lotto.validate;

import static lotto.error.ErrorType.*;

import java.util.regex.Pattern;
import lotto.error.ErrorType;

public class NumberValidator {

    /**
     * 공통 검증 로직입니다.
     */
    private void validateCommon(String number) {
        if (Pattern.matches(".*\\s.*", number)) {
            throw new IllegalArgumentException(NOT_BLANK.showMessage());
        }

        if (Pattern.matches(".*\\D.*", number)) {
            throw new IllegalArgumentException(ONLY_NUMBERS.showMessage());
        }
    }

    public void validateBuyMoney(String money) {
        validateCommon(money);

        if (Integer.parseInt(money) < 0) {
            throw new IllegalArgumentException(LOWER_MONEY.showMessage());
        }

        if (Integer.parseInt(money) % 1000 != 0) {
            throw new IllegalArgumentException(NOT_DIVIDE.showMessage());
        }
    }

    public void validateInputNumber(String input) {
        validateCommon(input);



    }

}
