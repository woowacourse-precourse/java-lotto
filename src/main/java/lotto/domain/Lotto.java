package lotto.domain;

import java.util.List;
import java.util.stream.Collectors;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        sizeValidate(numbers);

        uniqueValidate(numbers);
    }

    private void uniqueValidate(List<Integer> numbers) {
        List<Integer> uniqueNumbers = numbers.stream().distinct().collect(Collectors.toList());
        if (uniqueNumbers.size() != numbers.size()) {
            throw new IllegalArgumentException();
        }
    }

    private void sizeValidate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException();
        }
    }
}
