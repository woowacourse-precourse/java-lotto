package lotto;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Lotto {
    private final List<Integer> numbers;
    public static final int LOTTO_SIZE = 6;
    public static final int MIN_NUMBER = 1;
    public static final int MAX_NUMBER = 45;
    public static final String DUPLICATE_NUMBERS = "중복된 숫자가 있습니다.";
    public static final String NUMBERS_OUT_OF_RANGE = "범위를 벗어나는 번호가 있습니다.";
    public static final String WRONG_SIZE_OF_NUMBERS = "번호의 개수가 올바르지 않습니다.";

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    private void validate(List<Integer> numbers) {
        validateInputSize(numbers);
        validateRangeOfNumbers(numbers);
        validateUniqueness(numbers);
    }

    private void validateUniqueness(List<Integer> numbers) {
        Set<Integer> uniqueNumbers = new HashSet<>(numbers);
        if (uniqueNumbers.size() != LOTTO_SIZE) {
            throw new IllegalArgumentException(DUPLICATE_NUMBERS);
        }
    }

    private void validateRangeOfNumbers(List<Integer> numbers) {
        numbers.forEach(number -> {
            if (number < MIN_NUMBER || number > MAX_NUMBER) {
                throw new IllegalArgumentException(NUMBERS_OUT_OF_RANGE);
            }
        });
    }

    private void validateInputSize(List<Integer> numbers) {
        if (numbers.size() != LOTTO_SIZE) {
            throw new IllegalArgumentException(WRONG_SIZE_OF_NUMBERS);
        }
    }
}