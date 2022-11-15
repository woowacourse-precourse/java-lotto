package lotto.domain;

import static lotto.exception.ExceptionName.BONUS_NUMBER_DUPLICATE_EXCEPTION;
import static lotto.exception.ExceptionName.BONUS_NUMBER_NOT_INTEGER_EXCEPTION;
import static lotto.exception.ExceptionName.BONUS_NUMBER_RANGE_EXCEPTION;
import static lotto.exception.ExceptionName.NUMBER_OF_WINNING_NUMBERS;
import static lotto.exception.ExceptionName.WINNING_NUMBERS_DUPLICATE_EXCEPTION;
import static lotto.exception.ExceptionName.WINNING_NUMBERS_NOT_INTEGER_EXCEPTION;
import static lotto.exception.ExceptionName.WINNING_NUMBERS_NUMBERS_EXCEPTION;
import static lotto.exception.ExceptionName.WINNING_NUMBERS_RANGE_EXCEPTION;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class WinningNumber {

    private final List<Integer> numbers;
    private final int bonusNumber;

    public WinningNumber(List<Integer> numbers, int bonusNumber) {
        validateWinningNumbers(numbers);
        validateBonusNumber(bonusNumber, numbers);
        this.numbers = numbers;
        this.bonusNumber = bonusNumber;
    }

    public WinningNumber(String stringNumbers, String stringBonusNumber) {
        List<Integer> numbers = validateWinningNumbersInteger(stringNumbers);
        Integer bonusNumber = validateBonusNumberInteger(stringBonusNumber);
        validateWinningNumbers(numbers);
        validateBonusNumber(bonusNumber, numbers);
        this.numbers = numbers;
        this.bonusNumber = bonusNumber;
    }

    private List<Integer> validateWinningNumbersInteger(String stringNumbers) {
        List<String> numbers = new ArrayList<String>(Arrays.asList(stringNumbers.split(",")));
        List<Integer> integerNumbers = new ArrayList<>();
        try {
            for (String number : numbers) {
                integerNumbers.add(Integer.parseInt(number));
            }
        } catch (Exception e) {
            throw new IllegalArgumentException(WINNING_NUMBERS_NOT_INTEGER_EXCEPTION);
        }
        return integerNumbers;
    }

    private Integer validateBonusNumberInteger(String stringBonusNumber) {
        try {
            return Integer.parseInt(stringBonusNumber);
        } catch (Exception e) {
            throw new IllegalArgumentException(BONUS_NUMBER_NOT_INTEGER_EXCEPTION);
        }
    }

    private void validateWinningNumbers(List<Integer> numbers) {
        validateWinningNumbersSize(numbers);
        validateWinningNumbersRange(numbers);
        validateWinningNumbersDuplicate(numbers);
    }

    private void validateWinningNumbersSize(List<Integer> numbers) {
        if (numbers.size() != NUMBER_OF_WINNING_NUMBERS) {
            throw new IllegalArgumentException(WINNING_NUMBERS_NUMBERS_EXCEPTION);
        }
    }

    private void validateWinningNumbersRange(List<Integer> numbers) {
        for (int number : numbers) {
            if (number < 1 || number > 45) {
                throw new IllegalArgumentException(WINNING_NUMBERS_RANGE_EXCEPTION);
            }
        }
    }

    private void validateWinningNumbersDuplicate(List<Integer> integerNumbers) {
        Set<Integer> deduplicatedIntegerNumbers = new HashSet<>(integerNumbers);
        if (deduplicatedIntegerNumbers.size() != integerNumbers.size()) {
            throw new IllegalArgumentException(WINNING_NUMBERS_DUPLICATE_EXCEPTION);
        }
    }

    private void validateBonusNumber(int bonusNumber, List<Integer> numbers) {
        validateBonusNumberRange(bonusNumber);
        validateBonusNumberDuplicate(bonusNumber, numbers);
    }

    private void validateBonusNumberRange(int integerInput) {
        if (integerInput < 1 || integerInput > 45) {
            throw new IllegalArgumentException(BONUS_NUMBER_RANGE_EXCEPTION);
        }
    }

    private void validateBonusNumberDuplicate(int integerInput, List<Integer> numbers) {
        if (numbers.contains(integerInput)) {
            throw new IllegalArgumentException(BONUS_NUMBER_DUPLICATE_EXCEPTION);
        }
    }

    public int countMatch(Lotto lotto) {
        int count = 0;
        for (int number : numbers) {
            count += lotto.containNumber(number);
        }
        return count;
    }

    public boolean isBonus(Lotto lotto) {
        if (lotto.containNumber(bonusNumber) == 1) {
            return true;
        }
        return false;
    }
}
