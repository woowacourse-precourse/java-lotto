package lotto.model;

import java.util.List;
import java.util.stream.Collectors;

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

    private List<Integer> sortedLottoNumber() {
        return numbers.stream()
                .sorted(Integer::compare)
                .collect(Collectors.toList());
    }

    @Override
    public String toString() {
        List<Integer> result = sortedLottoNumber();
        return result.toString();
    }
}
