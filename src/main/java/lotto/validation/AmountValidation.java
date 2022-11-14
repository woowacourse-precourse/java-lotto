package lotto.validation;

import java.util.regex.Pattern;
import lotto.validation.enums.ErrorMessage;
import lotto.validation.enums.RegEx;

public class AmountValidation extends IllegalArgumentException {
    private static final int PRICE = 1000;

    private ErrorMessage message;
    private RegEx regEx;

    public AmountValidation() {
    }

    public void isValid(String amount) {
        isBlank(amount);
        isNumber(amount);
        isZero(amount);
        hasChanges(amount);
    }

    public void throwError(String msg) {
        throw new IllegalArgumentException(msg);
    }

    public void isBlank(String amount) {
        if (amount.isBlank()) {
            message = ErrorMessage.valueOf("BLANK_EXCEPTION");
            throwError(message.getMessage());
        }
    }

    public void isNumber(String amount) {
        regEx = RegEx.valueOf("NUMBER_REG_EX");
        if (!Pattern.matches(regEx.getRegEx(), amount)) {
            message = ErrorMessage.valueOf("NUMBER_EXCEPTION");
            throwError(message.getMessage());
        }
    }

    public void isZero(String amount) {
        regEx = RegEx.valueOf("ZERO_REG_EX");
        if (Pattern.matches(regEx.getRegEx(), amount)) {
            message = ErrorMessage.valueOf("ZERO_EXCEPTION");
            throwError(message.getMessage());
        }
    }

    public void hasChanges(String amount) {
        if (Integer.parseInt(amount) % PRICE != 0) {
            message = ErrorMessage.valueOf("CHANGES_EXCEPTION");
            throwError(message.getMessage());
        }
    }
}