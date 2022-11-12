package lotto.domain;

import lotto.utils.ErrorMessage;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Stream;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validateNumberSize(numbers);
        validateIsDistinct(numbers);
        sortLottoNumbers(numbers);
        this.numbers = numbers;
    }

    private void validateNumberSize(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException(ErrorMessage.LOTTO_NUMBER_IS_SIX);
        }
    }

    private void validateIsDistinct(List<Integer> numbers) {
        long distinctCount = numbers.stream().distinct().count();

        if (numbers.size() != distinctCount) {
            throw new IllegalArgumentException(ErrorMessage.LOTTO_NUMBER_IS_DISTINCT);
        }
    }

    private void sortLottoNumbers(List<Integer> numbers) {
        Collections.sort(numbers);
    }
}
