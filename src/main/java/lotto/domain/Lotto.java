package lotto.domain;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.regex.Pattern;
import lotto.ERROR;

public class Lotto {

    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        sortAsc(numbers);
        this.numbers = numbers;
    }

    public List<Integer> getNumbers() {
        return new ArrayList<>(numbers);
    }

    private void validate(List<Integer> numbers) {
        if (!isCorrectNumber(numbers)) {
            throw new IllegalArgumentException(ERROR.IS_NOT_CORRECT_NUMBER.getMessage());
        }

        if (hasDuplicateNumber(numbers)) {
            throw new IllegalArgumentException(ERROR.HAS_DUPLICATE_NUMBER.getMessage());
        }

        if (hasInvalidInput(numbers)) {
            throw new IllegalArgumentException(ERROR.IS_INVALID_INPUT.getMessage());
        }
    }

    private boolean isCorrectNumber(List<Integer> numbers) {
        return numbers.size() == 6;
    }

    private boolean hasDuplicateNumber(List<Integer> numbers) {
        HashSet<Integer> set = new HashSet<>(numbers);
        return set.size() < numbers.size();
    }

    private boolean hasInvalidInput(List<Integer> numbers) {
        Pattern isInvalidInputPattern = Pattern.compile("[^1-45]");
        return numbers.stream()
            .anyMatch(number -> isInvalidInputPattern
                .matcher(number.toString())
                .find()
            );
    }

    private void sortAsc(List<Integer> numbers) {
        numbers.sort(Comparator.naturalOrder());
    }
}
