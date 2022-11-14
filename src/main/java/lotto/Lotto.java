package lotto;

import java.nio.charset.IllegalCharsetNameException;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static lotto.ErrorMessage.*;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        validateSize(numbers);
        validateRange(numbers);
        validateDuplicate(numbers);
    }

    // TODO: 추가 기능 구현
    private void validateSize(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException(OUT_OF_SIZE_ERROR);
        }
    }

    private void validateRange(List<Integer> numbers) {
        for (int number : numbers) {
            if (number < 1 || number > 45) {
                throw new IllegalCharsetNameException(OUT_OF_RANGE_ERROR);
            }
        }
    }

    private void validateDuplicate(List<Integer> numbers) {
        Set<Integer> singleNumbers = new HashSet<>(numbers);
        if (singleNumbers.size() != numbers.size()) {
            throw new IllegalArgumentException(DUPLICATE_ERROR);
        }
    }




}
