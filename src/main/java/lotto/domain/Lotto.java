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
    }
    
    private void validateOutOfLength(final List<Integer> numbers) {
        if (isOutOfLength(numbers)) {
            throw new IllegalArgumentException();
        }
    }
    
    private boolean isOutOfLength(final List<Integer> numbers) {
        return numbers.size() != LENGTH_OF_LOTTO_NUMBERS;
    }
}
