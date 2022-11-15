package lotto.domain;

import lotto.resources.ErrorMessage;

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
            throw new IllegalArgumentException(ErrorMessage.SIZE_ERROR.getErrorMessage());
        }
        if (Set.copyOf(numbers).size() != 6) {
            throw new IllegalArgumentException(ErrorMessage.DUPLICATE_ERROR.getErrorMessage());
        }
    }

    public List<Integer> getLottoNumbers() {
        return numbers;
    }
}
