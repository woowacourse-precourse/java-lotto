package lotto.domain.lotto;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import lotto.common.LottoConstants;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = sort(numbers);
    }

    public int getNumberAt(int at) {
        return numbers.get(at);
    }

    public String formatString() {
        return Arrays.toString(numbers.toArray());
    }

    public boolean contains(int number) {
        return numbers.contains(number);
    }

    private void validate(List<Integer> numbers) {
        validateSize(numbers);
        validateDuplicated(numbers);
        validateRange(numbers);
    }

    private void validateSize(List<Integer> numbers) {
        if (numbers.size() != LottoConstants.LOTTO_SIZE) {
            throw new IllegalArgumentException();
        }
    }

    private void validateDuplicated(List<Integer> numbers) {
        int beforeSize = numbers.size();
        long afterDistinctSize = numbers.stream().distinct().count();

        if (beforeSize != afterDistinctSize) {
            throw new IllegalArgumentException();
        }
    }

    private void validateRange(List<Integer> numbers) {
        if (isGreaterThanRange(numbers)
                || isLessThanRange(numbers)) {
            throw new IllegalArgumentException();
        }
    }

    private boolean isGreaterThanRange(List<Integer> numbers) {
        return numbers.stream()
                .anyMatch(number -> number > LottoConstants.LOTTO_NUMBER_MAX_RANGE);
    }

    private boolean isLessThanRange(List<Integer> numbers) {
        return numbers.stream()
                .anyMatch(number -> number < LottoConstants.LOTTO_NUMBER_MIN_RANGE);
    }

    private List<Integer> sort(List<Integer> numbers) {
        return numbers.stream()
                .sorted()
                .collect(Collectors.toList());
    }
}
