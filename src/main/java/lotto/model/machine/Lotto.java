package lotto.model.machine;

import java.util.List;
import java.util.HashSet;
import java.util.ArrayList;

import lotto.model.lucky.BonusNumber;
import lotto.model.lucky.WinningNumber;

import java.util.concurrent.atomic.AtomicInteger;

public class Lotto implements Comparable<WinningNumber> {

    private static final int SIZE_OF_NUMBERS = 6;
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validateSize(numbers);
        validateDuplicate(numbers);
        this.numbers = new ArrayList<>(numbers);
    }

    private void validateSize(List<Integer> numbers) {
        if (numbers.size() != SIZE_OF_NUMBERS) {
            throw new IllegalArgumentException();
        }
    }

    private void validateDuplicate(List<Integer> numbers) {
        if (numbers.size() != new HashSet<>(numbers).size()) {
            throw new IllegalArgumentException();
        }
    }

    public boolean containsBonus(BonusNumber other) {
        for (Integer number : numbers) {
            if (other.contains(number)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public String toString() {
        return numbers.toString();
    }

    @Override
    public int compareTo(WinningNumber other) {
        AtomicInteger count = new AtomicInteger();
        for (Integer number : numbers) {
            if (other.contains(number)) {
                count.getAndIncrement();
            }
        }
        return count.get();
    }
}