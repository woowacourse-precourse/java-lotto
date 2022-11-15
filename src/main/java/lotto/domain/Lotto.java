package lotto.domain;

import static lotto.LottoConstant.WINNING_LOTTO_NUMBER_INPUT_HAS_SAME_NUMBER_ERROR_MESSAGE;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException();
        }
        Set<Integer> checkDuplicated = new HashSet<>(numbers);
        if (checkDuplicated.size() < 6) {
            throw new IllegalArgumentException(WINNING_LOTTO_NUMBER_INPUT_HAS_SAME_NUMBER_ERROR_MESSAGE);
        }
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    @Override
    public String toString() {
        return numbers.toString();
    }
}
