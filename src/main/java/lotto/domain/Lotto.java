package lotto.domain;

import java.util.List;
import lotto.utils.ExceptionMessage;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException(ExceptionMessage.LOTTO_NOT_VALID.getMessage());
        }
        if (!isValidRange(numbers)) {
            throw new IllegalArgumentException(ExceptionMessage.LOTTO_NOT_VALID.getMessage());
        }
        if (hasSameNumber(numbers)) {
            throw new IllegalArgumentException(ExceptionMessage.LOTTO_NOT_VALID.getMessage());
        }
    }

    private Boolean isValidRange(List<Integer> numbers) {
        for (int number : numbers) {
            if (number < 1 || number > 45) {
                return false;
            }
        }
        return true;
    }

    private Boolean hasSameNumber(List<Integer> numbers) {
        if (numbers.size() != numbers.stream().distinct().count()) {
            return true;
        }
        return false;
    }

    public List<Integer> getNumbers() {
        return numbers;
    }
}
