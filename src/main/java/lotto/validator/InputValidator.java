package lotto.validator;

import java.util.List;
import lotto.constants.message.ExceptionMessage;

public class InputValidator {
    public static final String ONLY_NUMBER = "^[0-9]*$";
    public static final String WINNING_NUMBER = "^([0-9]*,){5}[0-9]*$";

    public static final int NOTHING = 0;
    public static final int LOTTO_PRICE = 1000;
    public static final int ZERO = 0;
    public static final int FIRST_INDEX = 0;
    public static final String COMMA = ",";
    public static final int MAX_NUMBER = 6;
    public static final int MAXIMUM_NUMBER = 45;
    public static final int MINIMUM_NUMBER = 1;

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

    public void validateInputLottoNumber(String inputLottoNumber) {
        if (!inputLottoNumber.matches(WINNING_NUMBER)) {
            throw new IllegalArgumentException(ExceptionMessage.ERROR + ExceptionMessage.WINNING_FORMAT_ERROR);
        }
        if (isDuplicatedNumber(List.of(inputLottoNumber.split(COMMA)))) {
            throw new IllegalArgumentException(ExceptionMessage.ERROR + ExceptionMessage.DUPLICATED_NUMBER);
        }
        if (isOutOfBounds(List.of(inputLottoNumber.split(COMMA)))) {
            throw new IllegalArgumentException(ExceptionMessage.ERROR + ExceptionMessage.OUT_OF_BOUNDS);
        }
    }

    private boolean isOutOfBounds(List<String> splitInputWinningNumber) {
        return getMaximumNumber(splitInputWinningNumber) > MAXIMUM_NUMBER || getMinimumNumber(splitInputWinningNumber) < MINIMUM_NUMBER;
    }

    private static int getMinimumNumber(List<String> splitInputWinningNumber) {
        return splitInputWinningNumber.stream()
                .map(Integer::parseInt)
                .min(Integer::compareTo)
                .get();
    }

    private static int getMaximumNumber(List<String> splitInputWinningNumber) {
        return splitInputWinningNumber.stream()
                .map(Integer::parseInt)
                .max(Integer::compareTo)
                .get();
    }

    private boolean isDuplicatedNumber(List<String> splitInputWinningNumber) {
        return splitInputWinningNumber.stream()
                .distinct()
                .count() != MAX_NUMBER;
    }

}
