package lotto;

import java.util.List;
import java.util.stream.Collectors;

public class Lotto {

    private final List<Integer> numbers;
    private static final int MIN_NUMBER = 1;
    private static final int MAX_NUMBER = 45;
    private static final String LOTTO_LENGTH_ERR_MESSAGE = "[ERROR] 로또의 개수가 올바르지 않습니다.";
    private static final String LOTTO_RANGE_ERR_MESSAGE = "[ERROR] 로또의 범위가 올바르지 않습니다.";
    private static final String LOTTO_DUPLICATION_ERR_MESSAGE = "[ERROR] 로또에 중복이 존재합니다.";

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        validateLength(numbers);
        validateRange(numbers);
        validateDuplication(numbers);
    }

    private void validateLength(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException(LOTTO_LENGTH_ERR_MESSAGE);
        }
    }

    private void validateRange(List<Integer> numbers) {
        boolean validRange = numbers.stream().allMatch(num -> num >= MIN_NUMBER && num <= MAX_NUMBER);

        if (!validRange) {
            throw new IllegalArgumentException(LOTTO_RANGE_ERR_MESSAGE);
        }
    }

    private void validateDuplication(List<Integer> numbers) {
        List<Integer> uniqueNumbers = numbers.stream().distinct().collect(Collectors.toList());

        if (uniqueNumbers.size() != 6) {
            throw new IllegalArgumentException(LOTTO_DUPLICATION_ERR_MESSAGE);
        }
    }
}