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

    public List<Integer> getNumbers() {
        return numbers;
    }

    private void validate(List<Integer> numbers) {
        if (!(validateSize(numbers)&&validateRange(numbers) && validateDuplication(numbers))) {
            throw new IllegalArgumentException();
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
