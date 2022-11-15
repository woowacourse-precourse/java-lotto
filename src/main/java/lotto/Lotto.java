package lotto;

import static lotto.Validation.isDistinct;
import static lotto.Validation.outOfRange;
import static lotto.response.Error.LOTTO_NUMBER_COUNT_ERROR;
import static lotto.response.Error.LOTTO_NUMBER_DUPLICATION_ERROR;
import static lotto.response.Error.LOTTO_NUMBER_OUT_OF_RANGE_ERROR;

import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException(LOTTO_NUMBER_COUNT_ERROR.toString());
        }
        if (!isDistinct(numbers)) {
            throw new IllegalArgumentException(LOTTO_NUMBER_DUPLICATION_ERROR.toString());
        }
        if (outOfRange(numbers)) {
            throw new IllegalArgumentException(LOTTO_NUMBER_OUT_OF_RANGE_ERROR.toString());
        }
    }
}
