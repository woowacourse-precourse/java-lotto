package lotto.domain;

import lotto.utils.Error;
import lotto.utils.ErrorException;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Winning {
    private static final int MIN_LOTTO = 1;
    private static final int MAX_LOTTO = 45;

    private List<Integer> winningNumbers;
    private int bonusNumber;

    public Winning(List<Integer> winningNumbers) {
        this.winningNumbers = winningNumbers;
    }

    public Winning(int bonusNumber) {
        this.bonusNumber = bonusNumber;
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
