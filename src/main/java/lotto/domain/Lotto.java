package lotto.domain;

import lotto.util.InputValidator;

import java.util.*;
import java.util.stream.Collectors;

public class Lotto {

    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = sort(numbers);
    }

    private void validate(List<Integer> numbers) {
        InputValidator.validateLotto(numbers);
    }

    public List<Integer> getLotto() {
        return numbers;
    }

    private List<Integer> sort(List<Integer> numbers) {
        return numbers.stream()
                .sorted(Comparator.naturalOrder())
                .collect(Collectors.toList());
    }
}
