package lotto.utils;


import java.util.List;

import static lotto.utils.Constant.*;
import static lotto.utils.ExceptionMessage.*;

public class Validation {
    public static void validateNull(String input) {
        if (input.equals("")) {
            throw new IllegalArgumentException(NO_INPUT_VALUE.getMessage());
        }
    }

    public static int validateNumber(String input) {
        try {
            return Integer.parseInt(input);
        } catch (Exception e) {
            throw new IllegalArgumentException(IS_NOT_NUMBER.getMessage());
        }
    }

    public static void validateSize(List<Integer> numbers) {
        if (numbers.size() != Constant.LOTTO_SIZE.getValue()) {
            throw new IllegalArgumentException(INVALID_COUNT.getMessage());
        }
    }

    public static void validateRange(List<Integer> numbers) {
        for (int number : numbers) {
            validateSingleNumberRange(number);
        }
    }

    public static void validateSingleNumberRange(int number) {
        if (number < LOTTO_RANGE_START_NUM.getValue() || LOTTO_RANGE_END_NUM.getValue() < number) {
            String message = OUT_OF_LOTTO_NUMBER_RANGE.getMessage(LOTTO_RANGE_START_NUM.getValue(), LOTTO_RANGE_END_NUM.getValue());
            throw new IllegalArgumentException(message);
        }
    }


}
