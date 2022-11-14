package lotto.domain.lotto;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Lotto {
    private static final int LOTTO_NUMBERS_SIZE_LIMIT = 6;

    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        validateNumbersByOverSize(numbers);
        validateNumbersByDuplicatedNumber(numbers);
        validateNumbersByNumberRange(numbers);
    }

    private void validateNumbersByOverSize(List<Integer> numbers) {
        if (numbers.size() != LOTTO_NUMBERS_SIZE_LIMIT) {
            throw new IllegalArgumentException();
        }
    }

    private void validateNumbersByDuplicatedNumber(List<Integer> numbers) {
        Set<Integer> nonDuplicatedNumbers = new HashSet<>(numbers);
        if (nonDuplicatedNumbers.size() != LOTTO_NUMBERS_SIZE_LIMIT) {
            throw new IllegalArgumentException();
        }
    }

    private void validateNumbersByNumberRange(List<Integer> numbers) {

    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    public void printNumbers() {
        System.out.println(numbers);
    }
}
