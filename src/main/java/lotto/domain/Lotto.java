package lotto.domain;

import java.util.List;

import static constant.Constant.*;
import static constant.ErrorMessage.NOT_LOTTO_NUMBER_RANGE;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        validDuplicate(numbers);
        validNumberRange(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != LOTTO_SIZE) {
            throw new IllegalArgumentException();
        }
    }

    private void validDuplicate(List<Integer> numbers) {
        long delDuplicateSize = numbers.stream().distinct().count();
        if (numbers.size() != delDuplicateSize) {
            throw new IllegalArgumentException();
        }
    }

    private static void validNumberRange(List<Integer> numbers) {
        boolean isValid = numbers.stream()
                .noneMatch(num -> num < LOTTO_NUMBER_MIN || num > LOTTO_NUMBER_MAX);
        if (!isValid) {
            System.out.println(NOT_LOTTO_NUMBER_RANGE);
            throw new IllegalArgumentException(NOT_LOTTO_NUMBER_RANGE);
        }
    }

    @Override
    public String toString() {
        return numbers.toString();
    }

    public List<Integer> getNumbers() {
        return numbers;
    }
}
