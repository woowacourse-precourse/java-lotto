package lotto.domain;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        validateDuplicate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException();
        }
    }

    private void validateDuplicate(List<Integer> numbers) {
        Set<Integer> nonDuplicateNumbers = new HashSet<>(numbers);

        if (nonDuplicateNumbers.size() != numbers.size()) {
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

    public int getSumOfNumbers() {
        return numbers.stream()
            .reduce(0, Integer::sum);
    }
}
