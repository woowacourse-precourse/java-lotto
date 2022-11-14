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
        sizeCheck(numbers);
        duplicationCheck(numbers);
        rangeCheck(numbers);
    }

    private void sizeCheck(List<Integer> numbers) {
        if (numbers.size() != LottoConstants.LENGTH.getValue()) {
            throw new IllegalArgumentException();
        }
    }

    private void duplicationCheck(List<Integer> numbers) {
        Set<Integer> numbersWithoutDuplication = new HashSet<>(numbers);
        if (numbers.size() != numbersWithoutDuplication.size()) {
            throw new IllegalArgumentException();
        }
    }


    private void rangeCheck(List<Integer> numbers) {
        final int start = LottoConstants.START_NUMBER.getValue();
        final int end = LottoConstants.END_NUMBER.getValue();
        for (Integer number : numbers) {
            if (number < start || number > end) {
                throw new IllegalArgumentException();
            }
        }
    }
}
