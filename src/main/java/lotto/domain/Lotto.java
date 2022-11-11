package lotto.domain;

import lotto.exception.LottoError;

import java.util.Comparator;
import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        numbers.sort(Comparator.naturalOrder());
        this.numbers = numbers;
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    /**
     * 도메인 로직
     */
    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6)
            throw new IllegalArgumentException(LottoError.INVALID_NUMBERS_LENGTH.getErrorMessage());

        int count = (int) numbers.stream()
                .distinct()
                .count();
        if (count != numbers.size())
            throw new IllegalArgumentException(LottoError.DISTINCT_NUMBERS.getErrorMessage());
    }

}
