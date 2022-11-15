package lotto.utils;

import lotto.domain.Lotto;

import java.util.List;
import java.util.stream.Stream;

import static lotto.utils.constant.Constants.*;
import static lotto.exception.Exception.*;

public class Validator {
    public static void validateNumberFormat(String number) {
        try {
            Integer.parseInt(number);
        } catch (NumberFormatException e) {
            throwException(NOT_NUMBER.getMessage());
        }
    }

    public static void validateDivision(String purchaseCost) {
        int money = Integer.parseInt(purchaseCost);
        if(money % LOTTO_COST != ZERO || money <= ZERO) {
            throwException(WRONG_PURCHASE_COST.getMessage());
        }
    }

    public static void validateNumberCount(List<Integer> numbers) {
        int numberCount = numbers.size();
        if(numberCount != MAX_COUNT) {
            throwException(WRONG_COUNT.getMessage());
        }
    }

    public static void validateNumberRange(List<Integer> numbers) {
        boolean isOutOfRange = numbers.stream()
                .anyMatch(num -> (num < MIN || num > MAX));

        if(isOutOfRange) {
            throwException(OUT_OF_RANGE.getMessage());
        }
    }

    public static void validateDuplicate(List<Integer> numbers) {
        int distinctCount = (int)numbers.stream()
                .distinct().count();

        if(distinctCount != MAX_COUNT) {
            throwException(DUPLICATE.getMessage());
        }
    }

    public static void validateDelimiter(String numbers) {
        int numberCount = (int) Stream.of(numbers.split(EXCEPT_NUMBERS)).count();
        int delimiterCount = (int) Stream.of(numbers.split(NULL))
                .filter(c -> c.equals(DELIMITER))
                .count();

        if(delimiterCount != numberCount - 1) {
            throwException(WRONG_DELIMITER.getMessage());
        }
    }

    public static void validateNumberFormatForAll(String numbers) {
        Stream.of(numbers.split(DELIMITER))
                .forEach(Validator::validateNumberFormat);
    }

    public static void validateBonusNumberRange(String number) {
        int bonusNumber = Integer.parseInt(number);
        if(bonusNumber < MIN || bonusNumber > MAX) {
            throwException(OUT_OF_RANGE.getMessage());
        }
    }

    public static void validateDuplicateForBonus(String bonusNumber, Lotto winningNumbers) {
        List<Integer> numbers = winningNumbers.getNumbers();
        int bonus = Integer.parseInt(bonusNumber);
        if(numbers.contains(bonus)) {
            throwException(BONUS_DUPLICATE.getMessage());
        }
    }

    public static void throwException(String message) {
        throw new IllegalArgumentException(message);
    }
}
