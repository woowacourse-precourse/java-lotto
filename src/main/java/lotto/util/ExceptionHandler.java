package lotto.util;

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
        if (!(bonusNumber >= MIN_LOTTO_NUMBER && bonusNumber <= MAX_LOTTO_NUMBER)) {
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
            if (!(num >= MIN_LOTTO_NUMBER && num <= MAX_LOTTO_NUMBER)) {
                throw new IllegalArgumentException(RANGE_ERROR_MESSAGE);
            }
        });
    }

    public static void validateInputtedMoney(String money) {
        if (!money.matches(MONEY_REGEX)) {
            throw new IllegalArgumentException(MONEY_TYPE_ERROR_MESSAGE);
        }
    }

    public static void validateMoney(int money) {
        validateMoneyNotZero(money);
        validateMoneyCanDivide1000(money);

    }

    private static void validateMoneyNotZero(int money) {
        if(money == 0){
            throw new IllegalArgumentException(MONEY_VALUE_ZERO_ERROR_MESSAGE);
        }
    }

    private static void validateMoneyCanDivide1000(int money) {
        if (money % LOTTO_PRICE != 0) {
            throw new IllegalArgumentException(MONEY_VALUE_ERROR_MESSAGE);
        }
    }
}
