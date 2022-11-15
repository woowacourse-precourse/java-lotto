package lotto.domain;

import lotto.constants.LottoConstants;

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
        Validator.sizeCheck(numbers);
        Validator.duplicationCheck(numbers);
        Validator.rangeCheck(numbers);
    }

    public List<Integer> getNumbers() {
        return numbers;
    }
}
