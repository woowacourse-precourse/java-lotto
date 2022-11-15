package lotto.domain;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import lotto.constant.Constant;
import lotto.constant.ExceptionMessage;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) throws Exception {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) throws Exception {
        if (numbers.size() != Constant.LOTTO_LENGTH.getValue()) {
            throw new IllegalArgumentException(ExceptionMessage.INVALID_LOTTO_LENGTH.getString());
        }
        for (int number : numbers) {
            if (number < Constant.LOTTO_MIN_VALUE.getValue() || number > Constant.LOTTO_MAX_VALUE.getValue()) {
                throw new IllegalArgumentException(ExceptionMessage.INVALID_LOTTO_RANGE.getString());
            }
        }
        if (new HashSet<>(numbers).size() < Constant.LOTTO_LENGTH.getValue()) {
            throw new IllegalArgumentException(ExceptionMessage.INVALID_LOTTO_DUPLICATE.getString());
        }
    }

    public List<Integer> getLotto() {
        return numbers;
    }

}
