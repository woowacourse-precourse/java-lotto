package lotto.domain;

import lotto.exception.LottoError;

import java.util.List;
import java.util.stream.Collectors;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    /**
     * 도메인 로직
     */
    private void validate(List<Integer> numbers) throws RuntimeException {
        if (numbers.size() != 6)
            throw new IllegalArgumentException(LottoError.INVALID_NUMBERS_LENGTH.getErrorMessage());

        int count = (int) numbers.stream()
                .distinct()
                .count();
        if (count != numbers.size())
            throw new IllegalArgumentException(LottoError.DISTINCT_NUMBERS.getErrorMessage());
    }

    public List<Integer> sorted() {
        return numbers.stream().sorted().collect(Collectors.toList());
    }
}
