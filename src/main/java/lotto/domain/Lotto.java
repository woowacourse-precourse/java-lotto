package lotto.domain;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;
import java.util.stream.Collectors;

public class Lotto {
    private final SortedSet<Integer> numbers;

    public Lotto(List<Integer> unValidatedNumbers) {
        this.numbers = new TreeSet<>(unValidatedNumbers);
        validateSixNumber(numbers);
    }
    //지금 number 변수가 너무 많아
    public Lotto(String input) {
        this.numbers = toIntSet(separateCommas(input));

    }

    public Set<Integer> getNumbers() {
        return numbers;
    }

    private TreeSet<Integer> toIntSet(Set<String> separateCommas) {
        validateNumbers(separateCommas);
        Set<Integer> unValidatedNumbers = separateCommas.stream().map(number -> Integer.parseInt(number)).collect(Collectors.toSet());
        validateRange(unValidatedNumbers);
        validateSixNumber(unValidatedNumbers);
        TreeSet<Integer> treeSet = new TreeSet<>(unValidatedNumbers);
        return treeSet;
    }

    private void validateRange(Set<Integer> unValidatedNumbers) {
        if (unValidatedNumbers.stream().anyMatch(range -> range < 1 || range > 45)) {
            throw new IllegalArgumentException(Error.RANGE.getMessage());
        }
    }

    private void validateNumbers(Set<String> separateCommas) {
        for (String separateComma : separateCommas) {
            if (!separateComma.chars().allMatch(Character::isDigit)) {
                throw new IllegalArgumentException(Error.NUMBER.getMessage());
            }
        }
    }

    private Set<String> separateCommas(String input) {
        Set<String> inputs = new HashSet<>(Arrays.asList(input.split(",")));
        return inputs;
    }

    private void validateSixNumber(Set<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException(Error.COUNT.getMessage());
        }
    }

}
