package lotto.model.numbers;

import static lotto.util.Constants.NUMBER_COUNT;

import java.util.Collections;
import java.util.List;
import lotto.util.ExceptionMessage;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        validateSize(numbers);
        validateDuplicates(numbers);
    }

    private static void validateDuplicates(List<Integer> numbers) {
        if (numbers.stream().distinct().count() != NUMBER_COUNT) {
            throw new IllegalArgumentException(ExceptionMessage.INVALID_WINNING_NUMBER_DUPLICATE.getMessage());
        }
    }

    private static void validateSize(List<Integer> numbers) {
        if (numbers.size() != NUMBER_COUNT) {
            throw new IllegalArgumentException(ExceptionMessage.INVALID_WINNING_NUMBER_SIZE.getMessage());
        }
    }

    public boolean contains(int bonusNumber) {
        return numbers.contains(bonusNumber);
    }


    public List<Integer> getNumbers() {
        return numbers;
    }
}
