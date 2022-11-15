package lotto.service;

import java.util.List;
import java.util.stream.Collectors;

import static lotto.values.Constants.Digit.*;
import static lotto.values.Constants.Error.*;
import static lotto.values.Constants.Util.MONEY_REGEX;

public class ExceptionHandler {


    public static void validateLottoNumbers(List<Integer> numbers) {
        validateNumbersSize(numbers);
        validateNumberDuplication(numbers);
        validateNumbersRange(numbers);
    }

    public static void validateBonusNumber(int bonusNumber) {
        if (!(bonusNumber >= MIN_LOTTO_NUBMER && bonusNumber <= MAX_LOTTO_NUBMER)) {
            throw new IllegalArgumentException(RANGE_ERROR_MESSAGE);
        }
    }

    private static void validateNumbersSize(List<Integer> numbers) {
        if (numbers.size() != LOTTO_NUMBER_COUNT) {
            throw new IllegalArgumentException(SIZE_ERROR_MESSAGE);
        }
    }

    private static void validateNumberDuplication(List<Integer> numbers) {
        List<Integer> duplicationRemoved = numbers.stream().distinct().collect(Collectors.toList());

        if (duplicationRemoved.size() != LOTTO_NUMBER_COUNT) {
            throw new IllegalArgumentException(DUPLICATION_ERROR_MESSAGE);
        }
    }

    private static void validateNumbersRange(List<Integer> numbers) {
        numbers.forEach(num -> {
            if (!(num >= MIN_LOTTO_NUBMER && num <= MAX_LOTTO_NUBMER)) {
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
