package lotto.util;

import lotto.exception.*;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static lotto.constants.Constants.*;

public class InputValidator {

    public static void validateLotto(List<Integer> numbers) {
        isValidLottoSize(numbers);
        isDuplicateLotto(numbers);
        isNumbersInRange(numbers);
    }

    private static void isValidLottoSize(List<Integer> numbers) {
        if (numbers.size() != LOTTO_COST) {
            throw new InvalidSizeException();
        }
    }

    private static void isDuplicateLotto(List<Integer> numbers) {
        Set<Integer> lottoNumbers = new HashSet<>(numbers);
        if (numbers.size() != lottoNumbers.size()) {
            throw new hasDuplicateException();
        }
    }

    private static void isNumbersInRange(List<Integer> numbers) {
        for (int number : numbers) {
            isNumberInRange(number);
        }
    }

    private static void isNumberInRange(int number) {
        if (number < MIN_LOTTO_NUMBER || number > MAX_LOTTO_NUMBER) {
            throw new NumberOutOfRangeException();
        }
    }

    public static void validateMoney(String input) {
        isDigits(input);
        isDivisible(input);
    }

    private static void isDigits(String input) {
        for (char unit : input.toCharArray()) {
            isDigit(unit);
        }
    }

    private static void isDigit(char unit) {
        if (!Character.isDigit(unit)) {
            throw new InputNotIntegerException();
        }
    }

    private static void isDivisible(String input) {
        if (Integer.parseInt(input) % LOTTO_COST != 0) {
            throw new InputNonDivisibleException();
        }
    }

    public static void validateWinningLotto(String input) {
        String[] inputUnits = input.split(COMMA);

        isValidInputSize(inputUnits);
        isWinningNumbersInRange(inputUnits);
        isDuplicateWinningNumber(inputUnits);
    }

    private static void isValidInputSize(String[] inputUnits) {
        if (inputUnits.length != LOTTO_SIZE) {
            throw new InvalidSizeException();
        }
    }

    private static void isWinningNumbersInRange(String[] inputUnits) {
        for (String unit : inputUnits) {
            int number = isInteger(unit);
            if (number < MIN_LOTTO_NUMBER || number > MAX_LOTTO_NUMBER) {
                throw new NumberOutOfRangeException();
            }
        }
    }

    private static int isInteger(String unit) {
        try {
            int number = Integer.parseInt(unit);
            return number;
        } catch (NumberFormatException e) {
            throw new InputNotIntegerException();
        }
    }

    private static void isDuplicateWinningNumber(String[] inputUnits) {
        if (Arrays.stream(inputUnits)
                .distinct()
                .count() != LOTTO_SIZE) {
            throw new hasDuplicateException();
        }
    }

    public static void validateBonusNumber(String input) {
        isInteger(input);
        isBonusNumberInRange(input);
    }

    private static void isBonusNumberInRange(String input) {
        int number = Integer.parseInt(input);
        if (number < MIN_LOTTO_NUMBER || number > MAX_LOTTO_NUMBER) {
            throw new NumberOutOfRangeException();
        }
    }


}
