package lotto.util;


import static java.lang.Double.parseDouble;
import static java.lang.Integer.parseInt;
import static lotto.util.Constant.MONEY_UNIT;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Set;

public class Validator {

    public static void validateInputNumber(String inputNumber) {
        try {
            parseDouble(inputNumber);
        } catch (IllegalArgumentException e) {
            System.out.println(ErrorMessage.ERROR_MONEY_UNIT.getErrorMessage());
            throw new NoSuchElementException();
        }
    }

    public static void validateInputMoneyUnit(String inputMoney) {
        if (parseInt(inputMoney) % MONEY_UNIT != 0) {
            throw new IllegalArgumentException(ErrorMessage.ERROR_MONEY_UNIT.getErrorMessage());
        }
    }

    public static void validateInputNumberPositive(String inputNumber) {
        if (parseInt(inputNumber) < 1) {
            throw new IllegalArgumentException(ErrorMessage.ERROR_MONEY_UNIT.getErrorMessage());
        }
    }

    public static void validateDuplicateNumbers(List<Integer> numbers) {
        Set<Integer> numbersSet = new HashSet<>(numbers);

        if (numbersSet.size() != numbers.size()) {
            throw new IllegalArgumentException(ErrorMessage.ERROR_DUPLICATE_NUMBER.getErrorMessage());
        }
    }

    public static void validateRangeNumbers(List<Integer> numbers) {
        for (Integer number : numbers) {
            if (number > 45 || number == 0) {
                throw new IllegalArgumentException(ErrorMessage.ERROR_INPUT_TYPE.getErrorMessage());
            }
        }
    }

    public static List<Integer> validateComma(String inputWinningNumbers) {
        List<Integer> winningNumbers = new ArrayList<>();
        String[] inputNumbersArray = inputWinningNumbers.split(",");

        try {
            for (String s : inputNumbersArray) {
                winningNumbers.add(parseInt(s));
            }
            return winningNumbers;

        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException(ErrorMessage.ERROR_NEED_COMMA.getErrorMessage());
        }
    }

    public static void validateDuplicateBonusNumber(List<Integer> winningNumbers, String inputNumber) {
        for (Integer winningNumber : winningNumbers) {
            if (parseInt(inputNumber) == winningNumber) {
                throw new IllegalArgumentException(ErrorMessage.ERROR_DUPLICATE_NUMBER.getErrorMessage());
            }
        }
    }

    public static void validateRangeBonusNumber(String inputNumber) {
        int inputBonusNumber = parseInt(inputNumber);
        if (inputBonusNumber > 45 || inputBonusNumber == 0) {
                throw new IllegalArgumentException(ErrorMessage.ERROR_INPUT_TYPE.getErrorMessage());
            }

    }
}
