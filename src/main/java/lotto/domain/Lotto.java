package lotto.domain;

import lotto.exception.DuplicateLottoNumberException;
import lotto.exception.InvalidRangeLottoNumberException;
import lotto.exception.InvalidSizeLottoNumberException;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Lotto {
    private static final int LOTTO_SIZE = 6;
    private static final int MIN_RANGE = 1;
    private static final int MAX_RANGE = 45;

    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        numbers = sorted(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        validateSize(numbers);
        validateRange(numbers);
        validateDuplicate(numbers);
    }

    private void validateSize(List<Integer> numbers) {
        if (numbers.size() != LOTTO_SIZE) {
            throw new InvalidSizeLottoNumberException();
        }
    }

    private void validateRange(List<Integer> numbers) {
        numbers.forEach(this::validateRange);
    }

    private void validateRange(Integer number) {
        if (!(MIN_RANGE <= number && number <= MAX_RANGE)) {
            throw new InvalidRangeLottoNumberException();
        }
    }

    private void validateDuplicate(List<Integer> numbers) {
        Set<Integer> nonDuplicateNumbers = new HashSet<>(numbers);
        if (nonDuplicateNumbers.size() != LOTTO_SIZE) {
            throw new DuplicateLottoNumberException();
        }
    }

    public List<Integer> sorted(List<Integer> numbers) {
        return numbers.stream()
                .sorted()
                .collect(Collectors.toList());
    }

    @Override
    public String toString() {
        return numbers.toString();
    }
}
