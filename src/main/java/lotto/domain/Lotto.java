package lotto.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Lotto {
    private final Set<Integer> numbers;

    public Lotto(List<Integer> unValidatedNumbers) {
        Collections.sort(unValidatedNumbers);
        this.numbers = new LinkedHashSet<>(unValidatedNumbers);
        validateSixNumber(numbers);
    }
    //지금 넘버가 너무 많아
    public Lotto(String input) {
        this.numbers = toIntSet(separateCommas(input));

    }

    public Set<Integer> getNumbers() {
        return numbers;
    }

    private Set<Integer> toIntSet(Set<String> separateCommas) {
        validateNumbers(separateCommas);
        Set<Integer> unValidatedNumbers = separateCommas.stream().map(number -> Integer.parseInt(number)).collect(Collectors.toSet());
        validateRange(unValidatedNumbers);
        validateSixNumber(unValidatedNumbers);
        return unValidatedNumbers;
    }

    private void validateRange(Set<Integer> unValidatedNumbers) {
        if (unValidatedNumbers.stream().anyMatch(range -> range < 1 || range > 45)) {
            throw new IllegalArgumentException(Error.IS_NOT_RANGE.getMessage());
        }
    }

    private void validateNumbers(Set<String> separateCommas) {
        for (String separateComma : separateCommas) {
            if (separateComma.chars().allMatch(Character::isDigit)) {
                throw new IllegalArgumentException(Error.IS_NOT_NUMBER.getMessage());
            }
        }
    }

    private Set<String> separateCommas(String input) {
        Set<String> inputs = new HashSet<>(Arrays.asList(input.split(",")));
        return inputs;
    }

    private void validateSixNumber(Set<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException(Error.IS_NOT_SIX.getMessage());
        }
    }

}
