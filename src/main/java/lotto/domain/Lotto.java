package lotto.domain;

import java.util.List;

import static java.util.Collections.sort;
import static java.util.stream.Collectors.toList;
import static lotto.domain.ErrorType.*;

public class Lotto {
    public static final int LOTTO_SIZE = 6;
    public static final int LOTTO_START_NUMBER = 1;
    public static final int LOTTO_END_NUMBER = 45;
    public static final int LOTTO_PRICE = 1_000;
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validateLottoSize(numbers);
        validateEachNumberInRange(numbers, LOTTO_START_NUMBER, LOTTO_END_NUMBER);
        validateHasDuplicate(numbers);
        ascendingSort(numbers);
        this.numbers = numbers;
    }

    private void validateLottoSize(List<Integer> numbers) {
        if (numbers.size() != LOTTO_SIZE) {
            throw new IllegalArgumentException(ERROR_LOTTO_SIZE.getErrorMessage());
        }
    }

    private void validateEachNumberInRange(List<Integer> numbers, int startInclusive, int endInclusive) {
        for (int number : numbers) {
            if (number < startInclusive || number > endInclusive) {
                throw new IllegalArgumentException(ERROR_LOTTO_NUMBER_RANGE.getErrorMessage());
            }
        }
    }

    private void validateHasDuplicate(List<Integer> numbers) {
        List<Integer> removedDuplicates = numbers.stream()
                .distinct()
                .collect(toList());
        if (removedDuplicates.size() < LOTTO_SIZE) {
            throw new IllegalArgumentException(ERROR_LOTTO_HAS_DUPLICATE.getErrorMessage());
        }
    }

    private void ascendingSort(List<Integer> numbers) {
        sort(numbers);
    }

    public boolean containsBonusNumber(int bonusNumber) {
        return numbers.contains(bonusNumber);
    }

    public List<Integer> getNumbers() {
        return numbers;
    }
}