package lotto.domain;

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

    int getMatchingNumbers(final List<Integer> winningNumbers) {
        return (int)numbers.stream()
            .filter(winningNumbers::contains)
            .count();
    }

    boolean containsBonus(final int bonus) {
        return numbers.contains(bonus);
    }

    public CompareResult compareTo(final List<Integer> winningNumbers, final int bonus) {
        return new CompareResult(
            getMatchingNumbers(winningNumbers),
            containsBonus(bonus)
        );
    }

    @Override
    public String toString() {
        return numbers.toString();
    }
}
