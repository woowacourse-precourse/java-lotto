package lotto;

import lotto.view.OutputConsole;

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
            OutputConsole.printErrorMessage(PREFIX + NOT_INTEGER);
            throw new IllegalArgumentException(PREFIX + NOT_INTEGER);
        }
    }

    public static void isNegative(String input) {
        if (Integer.parseInt(input) < ZERO) {
            OutputConsole.printErrorMessage(PREFIX + NEGATIVE);
            throw new IllegalArgumentException(PREFIX + NEGATIVE);
        }
    }

    public static void isDividableWithThousand(String input) {
        if (Integer.parseInt(input) % LOTTO_PRICE != ZERO) {
            OutputConsole.printErrorMessage(PREFIX + NOT_DIVIDABLE_WITH_THOUSAND);
            throw new IllegalArgumentException(PREFIX + NOT_DIVIDABLE_WITH_THOUSAND);
        }
    }

    public static void isValidPurchasePrice(String input) {
        isInteger(input);
        isNegative(input);
        isDividableWithThousand(input);
    }

    public static void isValidLottoSize(List<Integer> numbers) {
        if (numbers.size() != LOTTO_SIZE) {
            OutputConsole.printErrorMessage(PREFIX + INVALID_LOTTO_SIZE);
            throw new IllegalArgumentException(PREFIX + INVALID_LOTTO_SIZE);
        }
    }

    public static void anyDuplicatedNumber(List<Integer> numbers) {
        if (numbers.size() != numbers.stream().distinct().count()) {
            OutputConsole.printErrorMessage(PREFIX + DUPLICATED_NUMBER);
            throw new IllegalArgumentException(PREFIX + DUPLICATED_NUMBER);
        }
    }

    public static void isValidNumberRange(List<Integer> numbers) {
        for (Integer number: numbers) {
            if (number < MIN_LOTTO_NUMBER || number > MAX_LOTTO_NUMBER) {
                OutputConsole.printErrorMessage(PREFIX + INVALID_LOTTO_NUMBER);
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
            OutputConsole.printErrorMessage(PREFIX + INVALID_PRIZE_NUMBER_FORMAT);
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
            OutputConsole.printErrorMessage(PREFIX + DUPLICATED_BONUS_NUMBER);
            throw new IllegalArgumentException(PREFIX + DUPLICATED_BONUS_NUMBER);
        }
    }
}
