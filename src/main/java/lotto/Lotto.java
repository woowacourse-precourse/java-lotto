package lotto;

import lotto.exception.ErrorCode;
import lotto.exception.MyIllegalArgumentException;

import java.util.List;

public class Lotto {
    private static final int SIZE = 6;
    private static final int START_NUMBER = 1;
    private static final int END_NUMBER = 45;
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (isInValidSize(numbers)) {
            throw new MyIllegalArgumentException(ErrorCode.LOTTO_SIZE_ERROR);
        }
        if (hasOutOfBoundNumber(numbers)) {
            throw new MyIllegalArgumentException(ErrorCode.LOTTO_BOUND_ERROR);
        }
        if (hasDuplicateNumber(numbers)) {
            throw new MyIllegalArgumentException(ErrorCode.LOTTO_DUPLICATE_ERROR);
        }
    }

    private static boolean isInValidSize(List<Integer> numbers) {
        return numbers.size() != SIZE;
    }

    private static boolean hasOutOfBoundNumber(List<Integer> numbers) {
        return numbers.stream().anyMatch(x -> x < START_NUMBER || x > END_NUMBER);
    }

    private static boolean hasDuplicateNumber(List<Integer> numbers) {
        return numbers.stream().distinct().count() != numbers.size();
    }
}
