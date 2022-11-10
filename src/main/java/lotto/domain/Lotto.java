package lotto.domain;

import java.util.List;

public class Lotto {
    private static final int LENGTH_OF_LOTTO_NUMBERS = 6;
    
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        validateOutOfLength(numbers);
        validateExistDuplicateNumber(numbers);
    }
    
    private void validateOutOfLength(final List<Integer> numbers) {
        if (isOutOfLength(numbers)) {
            throw new IllegalArgumentException();
        }
    }
    
    private boolean isOutOfLength(final List<Integer> numbers) {
        return isSameLength(numbers.size(), LENGTH_OF_LOTTO_NUMBERS);
    }
    
    private void validateExistDuplicateNumber(final List<Integer> numbers) {
        if (isSameLength(numbers.size(), lengthAfterDeduplication(numbers))) {
            throw new IllegalArgumentException();
        }
    }
    
    private boolean isSameLength(final int lottoNumbersLength, final int lengthToCompare) {
        return lottoNumbersLength != lengthToCompare;
    }
    
    private int lengthAfterDeduplication(final List<Integer> numbers) {
        return (int) numbers.stream()
                .distinct()
                .count();
    }
}
