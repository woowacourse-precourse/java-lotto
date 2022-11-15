package lotto.exception;

import lotto.domain.Lotto;

import java.util.List;
import java.util.stream.Stream;

import static lotto.constant.Constants.*;
import static lotto.constant.MessageConstants.*;

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

    public static void validateDuplicate(List<Integer> numbers) {
        int distinctCount = (int)numbers.stream()
                .distinct().count();

        if(distinctCount != MAX_COUNT) {
            throwException(DUPLICATE_MESSAGE);
        }
    }

    public static void validateDelimiter(String numbers) {
        int delimiterCount = (int) Stream.of(numbers.split(NULL))
                .filter(c -> c.equals(DELIMITER))
                .count();

        if(delimiterCount != CORRECT_DELIMITER_COUNT) {
            throwException(WRONG_DELIMITER_MESSAGE);
        }
    }

    public static void validateNumberFormatForAll(String numbers) {
        Stream.of(numbers.split(DELIMITER))
                .forEach(Exception::validateNumberFormat);
    }

    public static void validateBonusNumberRange(String number) {
        int bonusNumber = Integer.parseInt(number);
        if(bonusNumber < MIN || bonusNumber > MAX) {
            throwException(WRONG_RANGE_MESSAGE);
        }
    }

    public static void validateDuplicateForBonus(String bonusNumber, Lotto winningNumbers) {
        List<Integer> numbers = winningNumbers.getNumbers();
        int bonus = Integer.parseInt(bonusNumber);
        if(numbers.contains(bonus)) {
            throwException(BONUS_DUPLICATE_MESSAGE);
        }
    }

    public static void throwException(String message) {
        throw new IllegalArgumentException(ERROR + message);
    }
}
