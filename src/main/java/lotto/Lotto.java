package lotto;

import constants.LottoConstants;
import constants.UIConstants;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException(UIConstants.INVALID_LOTTO_COUNT_NUMBERS);
        }
        Set<Integer> noDuplicatedNumbers = numbers.stream().collect(Collectors.toSet());
        if (noDuplicatedNumbers.size() != 6) {
            throw new IllegalArgumentException(UIConstants.DUPLICATED_LOTTO_NUMBERS);
        }
        for (int number : noDuplicatedNumbers) {
            if (number < LottoConstants.MIN_LOTTO_VALUE ||
                    number > LottoConstants.MAX_LOTTO_VALUE) {
                throw new IllegalArgumentException(UIConstants.INVALID_RANGE_LOTTO_NUMBERS);
            }
        }
    }

    @Override
    public String toString() {
        return numbers.stream().sorted().collect(Collectors.toList()).toString();
    }
}
