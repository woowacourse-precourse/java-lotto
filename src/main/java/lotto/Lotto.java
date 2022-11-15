package lotto;

import java.util.List;
import lotto.Constant.LottoValidationError;

public class Lotto {
    public static final int PRICE = 1000;

    public static final int NUMBER_CNT = 6;
    public static final int NUMBER_MIN = 1;
    public static final int NUMBER_MAX = 45;

    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        validateNumbersCount(numbers);
        validateNumbersRange(numbers);
        validateNumbersDuplicate(numbers);
    }

    private void validateNumbersCount(List<Integer> numbers) {
        if (numbers.size() != NUMBER_CNT) {
            throw LottoValidationError.COUNT.exception;
        }
    }

    private void validateNumbersRange(List<Integer> numbers) {
        for (int i : numbers) {
            if (i < Lotto.NUMBER_MIN || i > Lotto.NUMBER_MAX) {
                throw LottoValidationError.RANGE.exception;
            }
        }
    }

    private void validateNumbersDuplicate(List<Integer> numbers) {
        boolean[] duplicate = new boolean[NUMBER_MAX + 1];
        for (int i : numbers) {
            if (duplicate[i]) {
                throw LottoValidationError.DUPLICATE.exception;
            }
            duplicate[i] = true;
        }
    }

    // TODO: 추가 기능 구현
    public List<Integer> getNumbers() {
        return this.numbers;
    }
}
