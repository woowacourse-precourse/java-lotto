package lotto;

import java.util.HashSet;
import java.util.List;

public class Lotto {

    private static final String LOTTO_NUMBER_ERROR_MESSAGE = "로또 번호 개수는 6개여야 합니다.";
    private static final String LOTTO_DUPLICATE_ERROR_MESSAGE = "로또 번호는 중복되어선 안됩니다.";

    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException(LOTTO_NUMBER_ERROR_MESSAGE);
        }

        if (isDuplicated(numbers)) {
            throw new IllegalArgumentException(LOTTO_DUPLICATE_ERROR_MESSAGE);
        }
    }

    private boolean isDuplicated(List<Integer> numbers) {
        return new HashSet<>(numbers).size() != numbers.size();
    }

}
