package lotto.domain;

import java.util.*;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> rowNumbers) {
        validate(rowNumbers);
        List<Integer> sortedNumbers = new ArrayList<>(rowNumbers);
        sortedNumbers.sort(Comparator.naturalOrder());
        this.numbers = sortedNumbers;
    }

    private void validate(List<Integer> numbers) {
        validateNumberSize(numbers);
        validateDuplicateNumbers(numbers);
        validateNumberRange(numbers);
    }

    private void validateNumberSize(List<Integer> numbers) {
        final int LOTTO_NUMBER_SIZE = 6;
        final String SIZE_ERROR_MESSAGE = "[ERROR] 로또 번호의 개수는 6이어야 합니다.";

        if (numbers.size() != LOTTO_NUMBER_SIZE) {
            throw new IllegalArgumentException(SIZE_ERROR_MESSAGE);
        }
    }

    private void validateDuplicateNumbers(List<Integer> numbers) {
        final String DUPLICATION_ERROR_MESSAGE = "[ERROR] 로또 번호에 중복된 숫자가 있으면 안 됩니다.";
        if (
                numbers.size() != numbers.stream()
                        .distinct()
                        .count()
        ) {
            throw new IllegalArgumentException(DUPLICATION_ERROR_MESSAGE);
        }
    }

    private void validateNumberRange(List<Integer> numbers) {
        final int MIN_NUMBER = 1;
        final int MAX_NUMBER = 45;
        final String RANGE_ERROR_MESSAGE = "[ERROR] 로또 번호는 1이상 45이하의 숫자만 가능합니다.";
        long overRangeCount = numbers.stream()
                .filter(number -> number < MIN_NUMBER || number > MAX_NUMBER)
                .count();

        if (overRangeCount > 0){
            throw new IllegalArgumentException(RANGE_ERROR_MESSAGE);
        }
    }

    public List<Integer> getNumbers() {
        return numbers;
    }
}
