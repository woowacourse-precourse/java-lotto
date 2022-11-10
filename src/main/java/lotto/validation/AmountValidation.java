package lotto.validation;

import java.util.regex.Pattern;

public class AmountValidation extends IllegalArgumentException {
    private ErrorMessage message;
    private RegEx regEx;

    public AmountValidation() {
    }

    public void throwError(String msg) {
        throw new IllegalArgumentException(msg);
    }

    public void isNull(String amount) {
        if (amount.isEmpty()) {
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

    }

    public void hasChanges(String amount) {

    }
}