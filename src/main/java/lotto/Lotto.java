package lotto;

import java.util.List;

import static lotto.Constants.LOTTO_NUMBERS_COUNT;
import static lotto.message.ExceptionMessage.*;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    private void validate(List<Integer> numbers) {
        sizeValidate(numbers);
        duplicateValidate(numbers);
    }

    private void sizeValidate(List<Integer> numbers) {
        if (!isSizeEq(numbers)) {
            throw new IllegalArgumentException(SIZE_EXCEPTION);
        }
    }

    private boolean isSizeEq(List<Integer> numbers) {
        return numbers.size() != LOTTO_NUMBERS_COUNT;
    }

    private void duplicateValidate(List<Integer> numbers) {
        if (isDuplicateExist(numbers)) {
            throw new IllegalArgumentException(DUPLICATE_EXCEPTION);
        }
    }

    private boolean isDuplicateExist(List<Integer> numbers) {
        return numbers.size() != numbers.stream().distinct().count();
    }
}
