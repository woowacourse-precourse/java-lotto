package lotto;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        validateInputDuplicatedNumbers(numbers);
        validateNumberRange(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException();
        }
    }

    private void validateInputDuplicatedNumbers(List<Integer> numbers) {
        Set<Integer> number = new HashSet<>(numbers);
        if (number.size() != 6) {
            throw new IllegalArgumentException(Error.DUPLICATED_NUMBERS.getMessage());
        }
    }

    private void validateNumberRange(List<Integer> numbers) {
        for (int num : numbers) {
            if (num < 1 || num > 45) {
                throw new IllegalArgumentException(Error.NUMBER_OUT_OF_RANGE.getMessage());
            }
        }
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    public boolean existsNumber(int number) {
        return numbers.contains(number);
    }

    public int countMatchingNumber(List<Integer> numbers) {
        int count = 0;
        for (int number : numbers) {
            if (this.numbers.contains(number)) {
                count ++;
            }
        }
        return count;
    }
}
