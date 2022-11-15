package lotto.domain;

import lotto.utils.Error;
import lotto.utils.ErrorException;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Winning {
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
}
