package lotto.exception;

public class CommonException {

    static void checkInteger(String inputNumber) {
        try {
            Integer.parseInt(inputNumber);
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException(ErrorMessage.INPUT_NOT_INT.getMessage());
        }
    }
}
