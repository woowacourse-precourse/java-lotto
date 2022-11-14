package lotto;

import static lotto.Constants.MAX_NUMBER;
import static lotto.Constants.MIN_NUMBER;
import static lotto.Constants.WINNING_NUMBERS_SIZE;
import static lotto.ErrorMessages.DUPLICATE_NUMBER;
import static lotto.ErrorMessages.NOT_BETWEEN_ONE_AND_FORTY_FIVE;
import static lotto.ErrorMessages.NOT_SIX_DIGIT_NUMBER;

import java.util.Collections;
import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        validateLength(numbers);
        validateDuplicate(numbers);
        validateRange(numbers);
    }

    private void validateLength(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException(NOT_SIX_DIGIT_NUMBER);
        }
    }

    private static void validateDuplicate(List<Integer> numbers) {
        if (numbers.stream().distinct().count() != WINNING_NUMBERS_SIZE) {
            throw new IllegalArgumentException(DUPLICATE_NUMBER);
        }
    }

    private static void validateRange(List<Integer> numbers) {
        if (!numbers.stream().allMatch(number -> MIN_NUMBER <= number && number <= MAX_NUMBER)) {
            throw new IllegalArgumentException(NOT_BETWEEN_ONE_AND_FORTY_FIVE);
        }
    }

    public List<Integer> getNumbers() {
        return Collections.unmodifiableList(numbers);
    }
}
