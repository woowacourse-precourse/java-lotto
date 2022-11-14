package lotto.domain;

import lotto.utils.Error;
import lotto.utils.ErrorException;

import java.util.List;
import java.util.stream.Collectors;

public class Lotto {
    private static final int LOTTO_SIZE = 6;
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validateNumbers(numbers);
        this.numbers = numbers;
    }

    private void validateNumbers(List<Integer> numbers) {
        if (numbers.size() != LOTTO_SIZE) {
            throw new ErrorException(Error.INVALID_LOTTO_SIZE.toString());
        }
    }

    public void includeDuplicates(List<Integer> numbers) {
        List<Integer> deduplicated = numbers.stream()
                .distinct().collect(Collectors.toList());
        if(deduplicated.size() != LOTTO_SIZE) {
            throw new ErrorException(Error.INCLUDE_DUPLICATE_VALUE.toString());
        }
    }
}
