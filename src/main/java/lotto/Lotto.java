package lotto;

import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }
    private void validate(List<Integer> numbers) {
        ExceptionController.validateWinNumber(numbers);
        if (numbers.size() != 6) {
            throw new IllegalArgumentException();
        }
    }
    public String toString() {
        return this.numbers.toString();
    }
    public List<Integer> getNumbers() {
        return this.numbers;
    }
}
