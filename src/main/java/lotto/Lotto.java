package lotto;

import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException();
        }
    }

    private int matchWinningNumber(List<Integer> winningNumbers) {
        int matchNumbers = 0;
        for (int i = 0; i < numbers.size(); i++) {
            if (winningNumbers.contains(numbers.get(i))) {
                matchNumbers++;
            }
        }
        return matchNumbers;
    }
}
