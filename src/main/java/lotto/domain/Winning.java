package lotto.domain;

import lotto.utils.Error;
import lotto.utils.ErrorException;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Winning {
    private static final int MIN_LOTTO = 1;
    private static final int MAX_LOTTO = 45;
    private static final int WINNING_SIZE = 6;
    private static final int BONUS_SIZE = 1;

    private final List<Integer> winningNumbers;
    private int bonusNumber;

    public Winning(String inputNumbers) {
        isNotNumeric(inputNumbers);
        this.winningNumbers = splitNumbers(inputNumbers);
        validateWinningNumbers();
    }

    public Winning(List<Integer> winningNumbers, String bonusNumber) {
        isNotNumeric(bonusNumber);
        this.winningNumbers = winningNumbers;
        validateBonusNumbers(bonusNumber);
        this.bonusNumber = Integer.parseInt(bonusNumber);
    }

    private void validateWinningNumbers() {
        if (isInvalidNumbersSize(winningNumbers, WINNING_SIZE)) {
            throw new ErrorException(Error.INVALID_LOTTO_SIZE.toString());
        }

        if (includeDuplicates()) {
            throw new ErrorException(Error.INCLUDE_DUPLICATE_VALUE.toString());
        }

        if (isInvalidNumberRange(winningNumbers)) {
            throw new ErrorException(Error.INVALID_LOTTO_RANGE.toString());
        }
    }

    private void validateBonusNumbers(String bonusNumber) {
        List<Integer> bonus = splitNumbers(bonusNumber);

        if (isInvalidNumbersSize(bonus, BONUS_SIZE)) {
            throw new ErrorException(Error.INVALID_BONUS_SIZE.toString());
        }

        if (isInvalidNumberRange(bonus)) {
            throw new ErrorException(Error.INVALID_LOTTO_RANGE.toString());
        }

        if (isIncludeBonus(bonusNumber)) {
            throw new ErrorException(Error.ALREADY_EXIST_WIN_NUMBER.toString());
        }
    }

    private void isNotNumeric(String inputNumbers) {
        if (!inputNumbers.replace(",", "").chars().allMatch(Character::isDigit)) {
            throw new ErrorException(Error.IS_NOT_NUMERIC.toString());
        }
    }

    private List<Integer> splitNumbers(String inputNumbers) {
        return Arrays.stream(inputNumbers.split(","))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }

    private boolean isInvalidNumbersSize(List<Integer> numbers, int numberSize) {
        return numbers.size() != numberSize;
    }

    private boolean includeDuplicates() {
        List<Integer> deduplicated = winningNumbers.stream()
                .distinct().collect(Collectors.toList());
        return winningNumbers.size() != deduplicated.size();
    }

    private boolean isInvalidNumberRange(List<Integer> numbers) {
        return numbers.stream()
                .anyMatch(number -> number < MIN_LOTTO || number > MAX_LOTTO);
    }

    private boolean isIncludeBonus(String bonusNumber) {
        return winningNumbers.contains(Integer.parseInt(bonusNumber));
    }

    public List<Integer> getWinningNumbers() {
        return winningNumbers;
    }

    public int getBonusNumber() {
        return bonusNumber;
    }
}
