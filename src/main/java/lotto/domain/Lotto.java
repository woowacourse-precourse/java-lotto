package lotto.domain;

import java.util.List;
import java.util.stream.Collectors;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        validateDuplicatedNumber(numbers);
        this.numbers = numbers;
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException(ErrorMessage.NUMBER_ERROR.getMessage());
        }
    }

    private void validateDuplicatedNumber(List<Integer> numbers) {
        long count = countDuplicatedNumber(numbers);
        if(count != numbers.size()) {
            throw new IllegalArgumentException(ErrorMessage.DUPLICATION_ERROR.getMessage());
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
