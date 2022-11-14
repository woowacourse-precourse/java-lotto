package lotto.validator;

import lotto.constants.message.ExceptionMessage;

public class InputValidator {
    public static final String ONLY_NUMBER = "^[0-9]*$";

    public static final int NOTHING = 0;
    public static final int LOTTO_PRICE = 1000;
    public static final int ZERO = 0;
    public static final int FIRST_INDEX = 0;

    public boolean validateInputPrice(String inputPrice) {
        if (!inputPrice.matches(ONLY_NUMBER)) {
            throw new IllegalArgumentException(ExceptionMessage.ERROR + ExceptionMessage.NON_NUMERIC_INPUT);
        }
        if (isZero(Integer.parseInt(inputPrice))) {
            throw new IllegalArgumentException(ExceptionMessage.ERROR + ExceptionMessage.ZERO_INPUT);
        }
        if (isStartWithZero(inputPrice.charAt(FIRST_INDEX))) {
            throw new IllegalArgumentException(ExceptionMessage.ERROR + ExceptionMessage.START_WItH_ZERO);
        }
        return isNotValidPrice(Integer.parseInt(inputPrice));
    }

    private boolean isStartWithZero(char firstNumber) {
        return Integer.parseInt(String.valueOf(firstNumber)) == ZERO;
    }

    private boolean isZero(int inputPrice) {
        return inputPrice == ZERO;
    }

    private boolean isNotValidPrice(int inputPrice) {
        return inputPrice % LOTTO_PRICE != NOTHING;
    }
}
