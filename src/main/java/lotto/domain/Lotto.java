package lotto.domain;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Lotto {

    private static final String SIZE_ERROR_MESSAGE = "[ERROR] 로또 번호는 6개의 숫자로 구성되어야 합니다.";
    private static final String RANGE_ERROR_MESSAGE = "[ERROR] 로또 번호는 1~45 사이의 숫자로 구성되어야 합니다.";
    private static final String DUPLICATE_ERROR_MESSAGE = "[ERROR] 중복된 숫자가 있습니다.";

    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validateSize(numbers);
        validateRange(numbers);
        validateDuplicate(numbers);
        this.numbers = numbers;
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    private void validateSize(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException(SIZE_ERROR_MESSAGE);
        }
    }

    private void validateRange(List<Integer> numbers) {
        for (int number : numbers) {
            if (number < 1 || number > 45) {
                throw new IllegalArgumentException(RANGE_ERROR_MESSAGE);
            }
        }
    }

    private void validateDuplicate(List<Integer> numbers) {
        Set<Integer> differentNumbers = new HashSet<>(numbers);
        if (differentNumbers.size() != numbers.size()) {
            throw new IllegalArgumentException(DUPLICATE_ERROR_MESSAGE);
        }
    }
}
