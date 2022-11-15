package lotto;

import java.util.List;

public class Lotto {
    private static final int LOTTO_NUMBER_COUNT = 6;

    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != LOTTO_NUMBER_COUNT) {
            throw new IllegalArgumentException();
        }
    }

    public void sort() {
        numbers.sort(Integer::compareTo);
    }

    public int compareWithWinningNumbers(List<Integer> winningNumbers) {
        int matchCount = 0;

        for (int winningNumber : winningNumbers) {
            if (this.contains(winningNumber)) {
                matchCount++;
            }
        }

        return matchCount;
    }

    public boolean contains(int number) {
        return numbers.contains(number);
    }

    @Override
    public String toString() {
        return numbers.toString();
    }
}
