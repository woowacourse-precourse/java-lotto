package util;

import constant.ErrorMessage;
import java.util.List;

public class Lotto {

    private static final int MAX_NUMBER = 45;
    private static final int MIN_NUMBER = 1;
    private static final int TICKET_SIZE = 6;
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (isInCorrectSize(numbers)) {
            throw new IllegalArgumentException(ErrorMessage.ERROR_INCORRECT_SIZE.getMessage());
        }
        if (isDuplicated(numbers)) {
            throw new IllegalArgumentException(ErrorMessage.ERROR_WINNING_DUPLICATE.getMessage());
        }
        if (isOverRange(numbers)) {
            throw new IllegalArgumentException(ErrorMessage.ERROR_WINNING_OVERRANGE.getMessage());
        }
    }

    private boolean isInCorrectSize(List<Integer> numbers) {
        return numbers.size() != TICKET_SIZE;
    }

    private boolean isOverRange(List<Integer> numbers) {
        return numbers.stream().anyMatch(number -> number < MIN_NUMBER || number > MAX_NUMBER);
    }

    private boolean isDuplicated(List<Integer> numbers) {
        return numbers.stream().distinct().count() != numbers.size();
    }


}
