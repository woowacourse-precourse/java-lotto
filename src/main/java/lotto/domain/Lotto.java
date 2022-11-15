package lotto.domain;

import java.util.List;

public class Lotto {

    static final int SIZE_OF_NUMBERS = 6;
    static final int MAXIMUM_NUMBER = 45;
    static final int MINIMUM_NUMBER = 1;
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    @Override
    public String toString() {
        return numbers.toString();
    }

    long countMatchingNumber(Lotto winNumbers) {
        return this.numbers.stream().filter(winNumbers.numbers::contains).count();
    }

    boolean contains(Bonus bonusNumber) {
        return numbers.contains(bonusNumber.getBonusNumber());
    }

    private void validate(List<Integer> numbers) {
        if (!(validateSize(numbers) && validateRange(numbers) && validateDuplication(numbers))) {
            throw new IllegalArgumentException(Error.lotto.value());
        }
    }

    private boolean validateSize(List<Integer> numbers) {
        return numbers.size() == SIZE_OF_NUMBERS;
    }

    private boolean validateRange(List<Integer> numbers) {
        return numbers.stream().allMatch(i -> MINIMUM_NUMBER <= i && i <= MAXIMUM_NUMBER);
    }

    private boolean validateDuplication(List<Integer> numbers) {
        return numbers.stream().distinct().count() == numbers.size();
    }
}
