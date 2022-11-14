package lotto.Function;

import java.util.List;

public class Checker {
    private final List<Integer> numbers;
    private final List<Integer> winningNumbers;

    public Checker(List<Integer> numbers, List<Integer> winningNumbers) {
        this.numbers = numbers;
        this.winningNumbers = winningNumbers;
    }

    public int winningNumCheck() {
        int result = 0;
        for (int i = 0; i < numbers.size(); i++) {
            if (winningNumbers.contains(numbers.get(i))) {
                result++;
            }
        }
        return result;
    }
}
