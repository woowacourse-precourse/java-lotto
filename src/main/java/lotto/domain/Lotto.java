package lotto.domain;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;
import java.util.stream.Collectors;

import static lotto.domain.Error.*;
import static lotto.domain.Number.*;

public class Lotto {
    private final SortedSet<Integer> numbers;

    public Lotto(List<Integer> unValidatedNumbers) {
        this.numbers = new TreeSet<>(unValidatedNumbers);
        validateSixCount(numbers);
    }

    public Lotto(String input) {
        this.numbers = toIntSet(separateInput(input));
    }

    public Set<Integer> getNumbers() {
        return numbers;
    }

    private TreeSet<Integer> toIntSet(Set<String> inputs) {
        validateNumbers(inputs);
        Set<Integer> unValidatedNumbers = inputs.stream()
                .map(input -> Integer.parseInt(input))
                .collect(Collectors.toSet());
        validateRange(unValidatedNumbers);
        validateSixCount(unValidatedNumbers);
        TreeSet<Integer> numbers = new TreeSet<>(unValidatedNumbers);
        return numbers;
    }

    private void validateRange(Set<Integer> unValidatedNumbers) {
        if (unValidatedNumbers.stream()
                .anyMatch(range -> range < MIN_LOTTO_NUMBER.getNumber() || range > MAX_LOTTO_NUMBER.getNumber())) {
            throw new IllegalArgumentException(RANGE.getMessage());
        }
    }

    private void validateNumbers(Set<String> inputs) {
        for (String input : inputs) {
            if (!input.chars().allMatch(Character::isDigit)) {
                throw new IllegalArgumentException(NUMBER.getMessage());
            }
        }
    }

    private Set<String> separateInput(String input) {
        Set<String> inputs = new HashSet<>(Arrays.asList(input.split(",")));
        return inputs;
    }

    private void validateSixCount(Set<Integer> numbers) {
        if (numbers.size() != SIX.getNumber()) {
            throw new IllegalArgumentException(COUNT.getMessage());
        }
    }
}
