package lotto.domain;

import java.util.List;
import lotto.exception.domain.LottoSizeException;
import lotto.exception.domain.LottoNumberDuplicateException;

public class Lotto {
    private static final int LOTTO_SIZE = 6;
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        validateSize(numbers);
        validateDuplicate(numbers);
    }

    private void validateSize(List<Integer> numbers) {
        if (numbers.size() != LOTTO_SIZE) {
            throw new LottoSizeException(LOTTO_SIZE);
        }
    }

    private void validateDuplicate(List<Integer> numbers) {
        long distinctCount = numbers.stream()
                .distinct()
                .count();
        if (numbers.size() != distinctCount) {
            throw new LottoNumberDuplicateException();
        }
    }
}
