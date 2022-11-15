package lotto.domain;

import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static lotto.enumtype.LottoValidationMsg.*;

public class Lotto {
    private static final int FIX_SIZE = 6;

    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        Collections.sort(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (validateNumbersSize(numbers)) {
            throw new IllegalArgumentException(String.format(OVER_LOTTO_FIX_SIZE_EXCEPTION.getMessage(), FIX_SIZE));
        }

        if (validateDuplicateNumbers(numbers)) {
            throw new IllegalArgumentException(DUPLICATE_NUMBER_EXCEPTION. getMessage());
        }
    }

    private boolean validateNumbersSize(List<Integer> numbers) {
        return numbers.size() != FIX_SIZE;
    }

    private boolean validateDuplicateNumbers(List<Integer> numbers) {
        Set<Integer> numberSet = new HashSet<>(numbers);
        return numberSet.size() != FIX_SIZE;
    }

    @Override
    public String toString() {
        return numbers + "";
    }
}
