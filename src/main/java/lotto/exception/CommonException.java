package lotto.exception;

public class CommonException {

    static void checkInteger(String inputNumber) {
        try {
            Integer.parseInt(inputNumber);
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException(ErrorMessage.INPUT_NOT_INT.getMessage());
        }
    }

    public static void checkNumberRange(int number) {
        if (number < 1 || number > 45) {
            throw new IllegalArgumentException(ErrorMessage.NUMBER_OUT_OF_RANGE.getMessage());
        }
    }
}
