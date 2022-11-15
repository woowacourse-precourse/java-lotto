package lotto.model;

import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        isValidate(numbers);
        this.numbers = numbers;
    }

    private void isValidate(List<Integer> numbers) {
        LottoValidator.isCorrectSize(numbers);
        LottoValidator.isDistinctNumbers(numbers, null);
        isCorrectRange(numbers);
    }

    private void isCorrectRange(List<Integer> numbers) {
        numbers.forEach(LottoValidator::isCorrectRange);
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    @Override
    public String toString() {
        return "" + numbers;
    }
}
