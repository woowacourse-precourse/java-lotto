package lotto.model;

import lotto.util.ArgumentExceptionMessage;
import lotto.util.LottoConstant;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    public List<Integer> getNumbers() {
        return this.numbers;
    }

    private void validate(List<Integer> numbers) {
        checkLength(numbers);
        checkRange(numbers);
        checkOverlap(numbers);
    }

    private void checkLength(List<Integer> numbers) {
        if (numbers.size() != LottoConstant.LOTTO_LENGTH.getValue()) {
            throw new IllegalArgumentException(ArgumentExceptionMessage.INPUT_LOTTO_UNCONFORMABLE_LENGTH.getMessage());
        }
    }

    private void checkRange(List<Integer> numbers) {
        if (numbers.stream().anyMatch(integer -> integer < LottoConstant.LOTTO_RANGE_MIN.getValue() || integer > LottoConstant.LOTTO_RANGE_MAX.getValue())) {
            throw new IllegalArgumentException(ArgumentExceptionMessage.INPUT_LOTTO_UNCONFORMABLE_NUMBER_RANGE.getMessage());
        }
    }

    private void checkOverlap(List<Integer> numbers) {
        Set<Integer> numbersOverlap = new HashSet<>(numbers);
        if (numbersOverlap.size() != LottoConstant.LOTTO_LENGTH.getValue()) {
            throw new IllegalArgumentException(ArgumentExceptionMessage.INPUT_LOTTO_NUMBER_OVERLAP.getMessage());
        }
    }

    @Override
    public String toString() {
        return this.numbers.toString();
    }
}
