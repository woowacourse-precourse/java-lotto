package lotto.domain;

import lotto.Statistic;

import java.util.*;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        List<Integer> mutable = new ArrayList<>(numbers);
        validateLength(mutable);
        validateOverlap(mutable);
        sortByAscending(mutable);
        this.numbers = mutable;
    }

    private void validateLength(List<Integer> numbers) {
        if (numbers.size() != Statistic.SAME_SIX.getValue()) {
            throw new IllegalArgumentException();
        }
    }

    private void validateOverlap(List<Integer> numbers) {
        HashSet<Integer> set = new HashSet<>(numbers);
        if (set.size() != Statistic.SAME_SIX.getValue()) {
            throw new IllegalArgumentException();
        }
    }

    private void sortByAscending(List<Integer> numbers) {
        Collections.sort(numbers);
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    public int countWinningNumbers(List<Integer> winningNumbers) {
        return (int) winningNumbers.stream()
                .filter(this::isExistWinningNumber)
                .count();
    }

    public boolean isExistWinningNumber(int number) {
        return this.numbers.contains(number);
    }
}
