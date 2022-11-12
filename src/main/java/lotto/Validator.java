package lotto;

import static lotto.Constants.*;

import java.util.List;
import java.util.stream.Collectors;

public class Validator {
    public static void checkIfNumeric(String input) {
        boolean isNumber = input.matches(ONLY_NUMBER_REGEX);
        if (!isNumber) {
            throw new IllegalArgumentException(ERROR_TITLE + NON_NUMERIC);
        }
    }

    public static void checkIfInThousands(String input) {
        String lastThreeDigits = input.substring(input.length() - 3);
        if (!lastThreeDigits.equals("000")) {
            throw new IllegalArgumentException(ERROR_TITLE + NOT_IN_THOUSANDS);
        }
    }

    public static void checkSize(List<Integer> numbers) {
        if (numbers.size() != LOTTO_SIZE) {
            throw new IllegalArgumentException(ERROR_TITLE + NOT_SIX_NUMBERS);
        }
    }

    public static void checkUniqueness(List<Integer> numbers) {
        List<Integer> numbersToBeValidated = numbers.stream()
                .distinct()
                .collect(Collectors.toList());
        if (numbersToBeValidated.size() != LOTTO_SIZE) {
            throw new IllegalArgumentException(ERROR_TITLE + DUPLICATE_NUMBERS);
        }
    }

    public static void checkRange(Integer number) {
        if (number < START_NUMBER_INCLUSIVE || number > END_NUMBER_INCLUSIVE) {
            throw new IllegalArgumentException(ERROR_TITLE + OUT_OF_RANGE);
        }
    }

    public static void checkFormat(String[] numbers) {
        if (numbers.length != LOTTO_SIZE) {
            throw new IllegalArgumentException(ERROR_TITLE + NO_COMMAS_FOUND);
        }
    }

    public static void checkIfBonusNumberIncludedInWinningNumbers(List<Integer> winningNumbers, Integer bonusNumber) {
        if (winningNumbers.contains(bonusNumber)) {
            throw new IllegalArgumentException(ERROR_TITLE + DUPLICATE_NUMBERS);
        }
    }
}
