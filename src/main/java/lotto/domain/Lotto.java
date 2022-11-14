package lotto.domain;

import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import lotto.domain.enums.LottoException;
import lotto.domain.enums.NumbersType;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    private void validate(List<Integer> numbers) {
        LottoException exception;
        if (numbers.size() != NumbersType.NUMBERS_SIZE.getValue()) {
            exception = LottoException.valueOf("SIZE_EXCEPTION");
            throw new IllegalArgumentException(exception.getMessage());
        }
        if (new HashSet<>(numbers).size() != numbers.size()) {
            exception = LottoException.valueOf("DUPLICATE_EXCEPTION");
            throw new IllegalArgumentException(exception.getMessage());
        }
    }

    public void ascending(List<Integer> numbers) {
        Collections.sort(numbers);
    }
}