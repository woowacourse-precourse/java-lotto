package lotto.model.machine;

import java.util.HashSet;
import java.util.List;

import java.util.concurrent.atomic.AtomicInteger;

import lotto.model.lucky.BonusNumber;
import lotto.model.lucky.WinningNumber;

import lotto.TryCatchException;

public class Lotto implements Comparable<WinningNumber> {

    private static final int SIZE_OF_NUMBERS = 6;
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validateSize(numbers);
        validateDuplicate(numbers);
        this.numbers = numbers;
    }

    private void validateSize(List<Integer> numbers) {
        try {
            if (numbers.size() != SIZE_OF_NUMBERS) {
                throw new IllegalArgumentException();
            }
        } catch (IllegalArgumentException e) {
            throw new TryCatchException("[ERROR] Lotto number size must be " + SIZE_OF_NUMBERS + ".");
        }
    }

    private void validateDuplicate(List<Integer> numbers) {
        try {
            if (numbers.size() != new HashSet<>(numbers).size()) {
                throw new IllegalArgumentException();
            }
        } catch (IllegalArgumentException e) {
            throw new TryCatchException("[ERROR] Lotto number must be not duplicate.");
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