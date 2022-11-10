package lotto;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static lotto.constant.Constants.DUPLICATED_NUMBER_ERROR_MESSAGE;
import static lotto.constant.Constants.INVALID_LENGTH_ERROR_MESSAGE;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException(INVALID_LENGTH_ERROR_MESSAGE);
        }

        Set<Integer> lottoSet = new HashSet<>(numbers);
        if (lottoSet.size() != 6) {
            throw new IllegalArgumentException(DUPLICATED_NUMBER_ERROR_MESSAGE);
        }
    }
    // TODO: 추가 기능 구현

}
