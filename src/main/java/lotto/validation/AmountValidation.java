package lotto.validation;

public class AmountValidation extends IllegalArgumentException {
    private ErrorMessage message;

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

    }

    public void isZero(String amount) {

    }

    public void hasChanges(String amount) {

    }
}