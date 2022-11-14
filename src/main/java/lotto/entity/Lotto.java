package lotto.entity;

import lotto.exception.CommonException;
import lotto.exception.ErrorMessage;

import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        checkNumbersSize(numbers);
        checkDuplication(numbers);
        for (int number : numbers) {
            CommonException.checkNumberRange(number);
        }
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    private static void checkNumbersSize(List<Integer> winningNumbers) {
        if (winningNumbers.size() != 6) {
            throw new IllegalArgumentException(ErrorMessage.NUMBERS_SIZE_NOT_SIX.getMessage());
        }
    }

    private static void checkDuplication(List<Integer> winningNumbers) {
        long deduplicatedCount = winningNumbers.stream().distinct().count();
        if (winningNumbers.size() != deduplicatedCount) {
            throw new IllegalArgumentException(ErrorMessage.DUPLICATION_EXISTS.getMessage());
        }
    }
}
