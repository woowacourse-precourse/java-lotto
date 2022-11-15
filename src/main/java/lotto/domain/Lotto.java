package lotto.domain;

import lotto.Validator;

import java.util.List;
import java.util.stream.Collectors;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        Validator.isValidLotto(numbers);
    }

    // TODO: 추가 기능 구현
    public List<Integer> getNumbers() {
        return this.numbers;
    }

    public boolean contains(int number) {
        return numbers.contains(number);
    }

    public List<Integer> getSortedNumbers() {
        return numbers.stream().sorted().collect(Collectors.toList());
    }
}
