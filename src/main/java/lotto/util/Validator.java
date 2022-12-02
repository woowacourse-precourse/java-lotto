package lotto.util;

import static lotto.util.Constants.MAX_RANGE;
import static lotto.util.Constants.MIN_RANGE;

import java.util.regex.Pattern;

public abstract class Validator {
    private static final Pattern NUMBER_REGEX = Pattern.compile("^[0-9]*$");

    abstract void validate(String userInput) throws IllegalArgumentException;

    static String removeSpace(String input) {
        return input.replaceAll(" ", "");
    }

    void validateNumber(String budget) {
        if (!NUMBER_REGEX.matcher(budget).matches()) {
            throw new IllegalArgumentException(ExceptionMessage.INVALID_NOT_NUMERIC.getMessage());
        }
    }

    void validateInputRange(String budget) {
        try {
            Integer.parseInt(budget);
        } catch (NumberFormatException exception) {
            throw new IllegalArgumentException(ExceptionMessage.INVALID_OUT_OF_INT_RANGE.getMessage());
        }
    }

    void validateLottoNumberRange(String lottoNumber) {
        int number = Integer.parseInt(lottoNumber);
        if (number < MIN_RANGE || number > MAX_RANGE) {
            throw new IllegalArgumentException(ExceptionMessage.INVALID_WINNING_NUMBER_LOTTO_RANGE.getMessage());
        }
    }

}
