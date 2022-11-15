package lotto.exception;

import java.util.List;

import static lotto.constant.MessageConstants.*;
import static lotto.constant.Constants.*;

public class Exception {
    public static void validateNumberFormat(String number) {
        try {
            Integer.parseInt(number);
        } catch (NumberFormatException e) {
            throwException(WRONG_FORMAT_MESSAGE);
        }
    }

    public static void validateDivision(String purchaseCost) {
        if(Integer.parseInt(purchaseCost) % LOTTO_COST != ZERO) {
            throwException(WRONG_PURCHASE_COST_MESSAGE);
        }
    }

    public static void validateNumberCount(List<Integer> numbers) {
        int numberCount = numbers.size();
        if(numberCount != MAX_COUNT) {
            throwException(WRONG_COUNT_MESSAGE);
        }
    }

    public static void validateNumberRange(List<Integer> numbers) {
        boolean isOutOfRange = numbers.stream()
                .anyMatch(num -> (num < MIN || num > MAX));

        if(isOutOfRange) {
            throwException(WRONG_RANGE_MESSAGE);
        }
    }

    public static void throwException(String message) {
        throw new IllegalArgumentException(ERROR + message);
    }
}
