package lotto;

import java.util.HashSet;
import java.util.List;

public class Lotto {

    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException(ErrorMessage.LOTTO_NUMBER_SHOULD_BE_SIX);
        }

        if (isDuplicated(numbers)) {
            throw new IllegalArgumentException(ErrorMessage.LOTTO_DUPLICATED);
        }
    }

    private boolean isDuplicated(List<Integer> numbers) {
        return new HashSet<>(numbers).size() != numbers.size();
    }

}
