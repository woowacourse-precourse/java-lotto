package model;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validateMaxSize(numbers);
        validateDuplication(numbers);
        validateRange(numbers);
        this.numbers = numbers;
    }

    private void validateMaxSize(List<Integer> numbers) {
        if (numbers.size() != LottoConstant.LOTTO_NUMBER_COUNT.getNumber()) {
            throw new IllegalArgumentException(ErrorMessage.OVERSIZE_ERROR_MESSAGE.getErrorMessage());
        }
    }

    private void validateDuplication(List<Integer> numbers) {
        Set<Integer> duplicateComparison = new HashSet<>(numbers);

        if (duplicateComparison.size() < numbers.size()) {
            throw new IllegalArgumentException(ErrorMessage.DUPLICATE_ERROR_MESSAGE.getErrorMessage());
        }
    }

    private void validateRange(List<Integer> numbers) {
        for (int i = 0; i < numbers.size(); i++) {
            if (numbers.get(i) < LottoConstant.MIN_LOTTO_NUMBER.getNumber() || numbers.get(i) > LottoConstant.MAX_LOTTO_NUMBER.getNumber()) {
                throw new IllegalArgumentException(ErrorMessage.OVERRANGE_ERROR_MESSAGE.getErrorMessage());
            }
        }
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

}
