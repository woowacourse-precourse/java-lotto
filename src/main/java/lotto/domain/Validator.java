package lotto.domain;

import static lotto.constants.ErrorConstants.DUPLICATE_NUMBER_ERROR_MESSAGE;
import static lotto.constants.ErrorConstants.IN_RANGE_NUMBER_ERROR_MESSAGE;
import static lotto.constants.ErrorConstants.NOT_NUMBER_ERROR_MESSAGE;
import static lotto.constants.ErrorConstants.PURCHASE_ERROR_MESSAGE;
import static lotto.constants.ErrorConstants.SEPARATOR_ERROR_MESSAGE;
import static lotto.constants.RegexConstants.COMMA;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class Validator {

    public static void purchase(String purchase) {
        checkNumber(purchase);
        if (Integer.parseInt(purchase) % 1000 != 0) {
            throw new IllegalArgumentException(PURCHASE_ERROR_MESSAGE);
        }
    }

    public static void winningNumbers(String winningNumbers) {
        if (!winningNumbers.contains(COMMA)) {
            throw new IllegalArgumentException(SEPARATOR_ERROR_MESSAGE);
        }
        Arrays.stream(winningNumbers.split(COMMA))
                .forEach(winningNumber -> {
                    checkNumber(winningNumber);
                    isGreaterThanOneAndLessThanFortyFive(winningNumber);
                });
        checkDuplicate(winningNumbers.split(COMMA));
    }

    public static void bonusNumber(String bonusNumber) {
        checkNumber(bonusNumber);
        isGreaterThanOneAndLessThanFortyFive(bonusNumber);
    }

    private static void isGreaterThanOneAndLessThanFortyFive(String number) {
        if (Integer.parseInt(number) < 1 || Integer.parseInt(number) > 45) {
            throw new IllegalArgumentException(IN_RANGE_NUMBER_ERROR_MESSAGE);
        }
    }

    public static void checkDuplicate(List<Integer> numbers) {
        HashSet<Integer> checkDuplicate = new HashSet<>(numbers);
        if (checkDuplicate.size() != 6) {
            throw new IllegalArgumentException(DUPLICATE_NUMBER_ERROR_MESSAGE);
        }
    }

    public static void checkDuplicate(List<Integer> winningNumbers, int bonusNumber) {
        if (winningNumbers.contains(bonusNumber)) {
            throw new IllegalArgumentException(DUPLICATE_NUMBER_ERROR_MESSAGE);
        }
    }

    private static void checkDuplicate(String[] numbers) {
        HashSet<String> checkDuplicate = new HashSet<>(List.of(numbers));
        if (checkDuplicate.size() != 6) {
            throw new IllegalArgumentException(DUPLICATE_NUMBER_ERROR_MESSAGE);
        }
    }

    private static void checkNumber(String number) {
        try {
            Integer.parseInt(number);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(NOT_NUMBER_ERROR_MESSAGE);
        }
    }
}
