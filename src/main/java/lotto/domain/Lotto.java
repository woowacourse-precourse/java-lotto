package lotto.domain;

import static lotto.domain.Error.DUPLICATE_NUMBER_ERROR;
import static lotto.domain.Error.NUMBER_SIZE_ERROR;
import static lotto.domain.Error.OUT_OF_RANGE_NUMBER_ERROR;

import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Lotto {
    private static final int LOTTO_MIN_NUMBER = 1;
    private static final int LOTTO_MAX_NUMBER = 45;
    private static final int LOTTO_NUMBER_SIZE = 6;

    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        Collections.sort(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        isSizeSix(numbers);
        isInRange(numbers);
        isDuplicate(numbers);
    }

    private void isSizeSix(List<Integer> numbers) {
        if (numbers.size() != LOTTO_NUMBER_SIZE) {
            throw new IllegalArgumentException(NUMBER_SIZE_ERROR.toString());
        }
    }

    private void isInRange(List<Integer> numbers) {
        for (int number : numbers) {
            if (!(number >= LOTTO_MIN_NUMBER && number <= LOTTO_MAX_NUMBER)) {
                throw new IllegalArgumentException(OUT_OF_RANGE_NUMBER_ERROR.toString());
            }
        }
    }

    private void isDuplicate(List<Integer> numbers) {
        Set<Integer> lottoNumber = new HashSet<>(numbers);
        if (numbers.size() != lottoNumber.size()) {
            throw new IllegalArgumentException(DUPLICATE_NUMBER_ERROR.toString());
        }
    }

    public List<Integer> getNumbers() {
        return this.numbers;
    }
}
