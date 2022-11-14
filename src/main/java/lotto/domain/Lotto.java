package lotto.domain;

import java.util.List;
import java.util.stream.Collectors;

public class Lotto {
    public static final String COUNT_ERROR_MESSAGE = "로또 번호의 개수는 6개여야 합니다.";
    public static final String DUPLICATION_ERROR_MESSAGE = "로또 번호는 중복되지 않아야 합니다.";
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        validateDuplicatedNumber(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException(Validation.ERROR_MESSAGE + " " + COUNT_ERROR_MESSAGE);
        }
    }

    private void validateDuplicatedNumber(List<Integer> numbers) {
        long count = countDuplicatedNumber(numbers);
        if(count != numbers.size()) {
            throw new IllegalArgumentException(Validation.ERROR_MESSAGE + " " + DUPLICATION_ERROR_MESSAGE);
        }
    }

    private long countDuplicatedNumber(List<Integer> numbers) {
        return numbers
                .stream()
                .distinct()
                .count();
    }

    @Override
    public String toString() {
        return this.numbers
                .stream()
                .sorted()
                .collect(Collectors.toList())
                .toString();
    }
}
