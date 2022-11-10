package lotto.model;

import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        NumbersValidator.isValid(numbers);
    }

    public int countMathNumbers(Lotto targetLotto) {
        return targetLotto.countMathNumbers(numbers);
    }

    private int countMathNumbers(List<Integer> otherNumbers) {
        return (int) numbers.stream()
                .filter(otherNumbers::contains)
                .count();
    }

    public boolean containsNumber(int number) {
        return numbers.contains(number);
    }

}
