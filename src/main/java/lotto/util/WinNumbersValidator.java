package lotto.util;

import java.util.Arrays;
import java.util.regex.Pattern;
import lotto.common.InputErrors;

public class WinNumbersValidator implements Validator {
    private static final String DIAMETER = ",";
    private static final int LOTTO_NUMBER_MIN_RANGE = 1;
    private static final int LOTTO_NUMBER_MAX_RANGE = 45;
    private static final int LOTTO_SIZE = 6;


    @Override
    public void validate(String userInput) throws IllegalArgumentException {
        validateNotNull(userInput);
        validateFormat(userInput);
        validateRange(userInput);
        validateSize(userInput);
        validateDuplicate(userInput);
    }

    private void validateNotNull(String userInput) {
        if (userInput.isBlank()) {
            throw new IllegalArgumentException(InputErrors.BLANK.getMessage());
        }
    }

    private void validateFormat(String userInput) {
        // (최대 2자리 숫자 + ,) 조합만 1 ~ 5번 반복되고, 최대 2자리 숫자가 이어진 패턴
        final String winNumberRegex = "^([1-9]?[0-9]\\,){1,5}([1-9]?[0-9])$";
        if (!Pattern.matches(winNumberRegex, userInput)) {
            throw new IllegalArgumentException(InputErrors.WIN_NUMBER_NOT_FORMAT.getMessage());
        }
    }

    private void validateRange(String userInput) {
        for (String winNumber : userInput.split(DIAMETER)) {
            int number = Integer.parseInt(winNumber);
            validateRange(number);
        }
    }

    private void validateRange(int number) {
        if (number < LOTTO_NUMBER_MIN_RANGE ||
                number > LOTTO_NUMBER_MAX_RANGE) {
            throw new IllegalArgumentException(InputErrors.WIN_NUMBER_OUT_OF_RANGE.getMessage());
        }
    }

    private void validateSize(String userInput) {
        if (userInput.split(DIAMETER).length != LOTTO_SIZE) {
            throw new IllegalArgumentException(InputErrors.WIN_NUMBER_MISMATCH_SIZE.getMessage());
        }
    }

    private void validateDuplicate(String userInput) {
        String[] numbers = userInput.split(DIAMETER);
        int beforeSize = numbers.length;
        long distinctSize = Arrays.stream(numbers)
                .distinct()
                .count();

        if (beforeSize != distinctSize) {
            throw new IllegalArgumentException(InputErrors.WIN_NUMBER_DUPLICATED.getMessage());
        }
    }
}
