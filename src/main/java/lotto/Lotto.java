package lotto;

import java.util.ArrayList;
import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    public Lotto(String numbers) {
        validateString(numbers);
        this.numbers = new ArrayList<>();
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException();
        }
    }

    private void validateString(String numbers) {
        if (isStringEmpty(numbers)) {
            throw new IllegalArgumentException(ExceptionMessage.LOTTO_WRONG_NUMBER_OF_VALUE.getMessage());
        }
    }

    private boolean isStringEmpty(String numbers) {
        return numbers == null || numbers.isBlank();
    }
}
