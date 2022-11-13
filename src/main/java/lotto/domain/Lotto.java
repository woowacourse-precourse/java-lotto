package lotto.domain;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        numbers.sort(Comparator.naturalOrder());
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        validateNumberSize(numbers);
        validateDuplicateNumbers(numbers);
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

    public List<Integer> getNumbers() {
        return numbers;
    }
}
