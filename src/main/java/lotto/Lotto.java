package lotto;

import util.ExceptionMessage;
import util.LottoRule;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validateSize(numbers);
        validateDuplicateNumber(numbers);
        this.numbers = numbers;
    }

    private void validateSize(List<Integer> numbers) throws IllegalArgumentException {
        if (numbers.size() != LottoRule.NUMBER_OF_SIZE) {
            throw new IllegalArgumentException(ExceptionMessage.OUT_OF_SIZE);
        }
    }

    private void validateDuplicateNumber(List<Integer> numbers) throws IllegalArgumentException {
        Set<Integer> checkedNumbers = new HashSet<>();
        for (int number : numbers) {
            if (checkedNumbers.contains(number)) {
                throw new IllegalArgumentException(ExceptionMessage.DUPLICATE_NUMBER);
            }
            checkedNumbers.add(number);
        }
    }

}
