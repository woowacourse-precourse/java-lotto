package lotto.domain;

import java.util.HashSet;
import java.util.List;

public class Lotto {
    private static LottoValidator validator = LottoValidator.getInstance();
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (!validator.isValidSize(numbers)) {
            throw new IllegalArgumentException();
        }
        if (!validator.isValidRangeNumbers(numbers)) {
            throw new IllegalArgumentException();
        }
        if (validator.isDuplicated(numbers)){
            throw new IllegalArgumentException();
        }
    }

    public List<Integer> getLottoNumbers() {
        return numbers;
    }
}
