package util;

import java.util.List;
import java.util.stream.Collectors;

import static values.Constants.Digit.LOTTO_PRICE;
import static values.Constants.Error.*;
import static values.Constants.Util.MONEY_REGEX;

public class ExceptionHandler {


    public static void validateLottoNumbers(List<Integer> numbers) {
        validateNumbersSize(numbers);
        validateNumberDuplication(numbers);
        validateNumbersRange(numbers);
    }

    public static void validateBonusNumber(int bonusNumber) {
        if (!(bonusNumber >= 1 && bonusNumber <= 45)) {
            throw new IllegalArgumentException(RANGE_ERROR_MESSAGE);
        }
    }


    private static void validateNumbersSize(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException(SIZE_ERROR_MESSAGE);
        }
    }

    private static void validateNumberDuplication(List<Integer> numbers) {
        List<Integer> duplicationRemoved = numbers.stream().distinct().collect(Collectors.toList());

        if (duplicationRemoved.size() != 6) {
            throw new IllegalArgumentException(DUPLICATION_ERROR_MESSAGE);
        }
    }

    private static void validateNumbersRange(List<Integer> numbers) {
        numbers.forEach(num -> {
            if (!(num >= 1 && num <= 45)) {
                throw new IllegalArgumentException(RANGE_ERROR_MESSAGE);
            }
        });
    }

    public static void validateInputtedMoney(String money) {
        if (!money.matches(MONEY_REGEX)) {
            throw new IllegalArgumentException(MONEY_VALUE_ERROR_MESSAGE);
        }
    }

    public static void validateMoney(int money) {
        if (money % LOTTO_PRICE != 0) {
            throw new IllegalArgumentException();
        }
    }
}
