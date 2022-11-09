package lotto.domain.lotto;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Lotto {
    static final String INVALID_SIZE_OF_LOTTO_NUMBERS = "로또 숫자는 6개만 입력할 수 있습니다.";
    static final String NOT_ALLOW_DUPLICATED_LOTTO_NUMBER = "중복 숫자는 입력될 수 없습니다.";
    static final String INVALID_RANGE_OF_LOTTO_NUMBER = "로또 번호는 1부터 45 사이의 숫자여야 합니다.";

    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        validateDuplication(numbers);
        validateRangeOfNumbers(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException(INVALID_SIZE_OF_LOTTO_NUMBERS);
        }
    }

    private void validateDuplication(List<Integer> numbers) {
        Set<Integer> setOfNumbers = new HashSet<>(numbers);
        if (setOfNumbers.size() != numbers.size()) {
            throw new IllegalArgumentException(NOT_ALLOW_DUPLICATED_LOTTO_NUMBER);
        }
    }

    private void validateRangeOfNumbers(List<Integer> numbers) {
        boolean presentInvalidNumber = numbers.stream()
                .anyMatch(number -> number < 1 || 45 < number);

        if (presentInvalidNumber) {
            throw new IllegalArgumentException(INVALID_RANGE_OF_LOTTO_NUMBER);
        }
    }
}
