package lotto.domain;

import lotto.enums.ErrorMessage;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Lotto {
    public static final int RANGE_MIN = 1;
    public static final int RANGE_MAX = 45;
    public static final int LOTTO_SIZE = 6;
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != LOTTO_SIZE) {
            throw new IllegalArgumentException(ErrorMessage.ERROR_NOT_LENGTH_NUMBER.getErrorMessage());
        }
        Set<Integer> overlap = new HashSet<>();
        for (int number : numbers) {
            numberOverlapCheck(overlap, number);
            numberMaxMinCheck(number);
        }
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    private void numberMaxMinCheck(int number) {
        if (number < RANGE_MIN || number > RANGE_MAX) {
            throw new IllegalArgumentException(ErrorMessage.ERROR_NOT_RANGE.getErrorMessage());
        }
    }

    private void numberOverlapCheck(Set<Integer> overlap, int number) {
        if (overlap.contains(number)) {
            throw new IllegalArgumentException(ErrorMessage.ERROR_NOT_SAME_NUMBER.getErrorMessage());
        }
        overlap.add(number);
    }

}
