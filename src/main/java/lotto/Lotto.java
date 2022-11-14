package lotto;

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
}
