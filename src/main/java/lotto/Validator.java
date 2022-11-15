package lotto;

import java.util.Arrays;
import java.util.List;

import static lotto.ErrorMessage.*;
import static lotto.domain.LottoConst.*;

public final class Validator {
    private static final Integer ZERO = 0;

    private Validator() {

    }

    public static void isInteger(String input) {
        try {
            Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(PREFIX + NOT_INTEGER);
        }
    }

    public static void isZero(String input) {
        if (Integer.parseInt(input) == ZERO) {
            throw new IllegalArgumentException(PREFIX + NEGATIVE);
        }
    }

    public static void isNegative(String input) {
        if (Integer.parseInt(input) < ZERO) {
            throw new IllegalArgumentException(PREFIX + NEGATIVE);
        }
    }

    public static void isDividableWithThousand(String input) {
        if (Integer.parseInt(input) % LOTTO_PRICE != ZERO) {
            throw new IllegalArgumentException(PREFIX + NOT_DIVIDABLE_WITH_THOUSAND);
        }
    }

    public static void isValidPurchasePrice(String input) {
        isInteger(input);
        isZero(input);
        isNegative(input);
        isDividableWithThousand(input);
    }

    public static void isValidLottoSize(List<Integer> numbers) {
        if (numbers.size() != LOTTO_SIZE) {
            throw new IllegalArgumentException(PREFIX + INVALID_LOTTO_SIZE);
        }
    }

    public static void anyDuplicatedNumber(List<Integer> numbers) {
        if (numbers.size() != numbers.stream().distinct().count()) {
            throw new IllegalArgumentException(PREFIX + DUPLICATED_NUMBER);
        }
    }

    public static void isValidNumberRange(List<Integer> numbers) {
        for (Integer number: numbers) {
            if (number < MIN_LOTTO_NUMBER || number > MAX_LOTTO_NUMBER) {
                throw new IllegalArgumentException(PREFIX + INVALID_LOTTO_NUMBER);
            }
        }
    }

    public static void isValidLotto(List<Integer> numbers) {
        isValidLottoSize(numbers);
        isValidNumberRange(numbers);
        anyDuplicatedNumber(numbers);
    }

    public static void isPrizeNumberFormat(String input) {
        if (!input.matches("^(\\d{1,2},){5}(\\d{1,2})$")) {
            throw new IllegalArgumentException(PREFIX + INVALID_PRIZE_NUMBER_FORMAT);
        }
    }

    public static void hasIntegers(String input) {
        List<String> splittedInput = Arrays.asList(input.split(","));
        splittedInput.forEach(token -> isInteger(token));
    }

    public static void isValidPrizeNumbers(String input) {
        isPrizeNumberFormat(input);
        hasIntegers(input);
    }

    public static void isValidBonusNumber(String input) {
        isInteger(input);
        isNegative(input);
        isValidNumberRange(List.of(Integer.parseInt(input)));
    }

    public static void containsBonusNumber(List<Integer> numbers, int bonusNumber) {
        if (numbers.contains(bonusNumber)) {
            throw new IllegalArgumentException(PREFIX + DUPLICATED_BONUS_NUMBER);
        }
    }
}
