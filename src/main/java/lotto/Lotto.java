package lotto;

import java.util.*;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(final List<Integer> numbers) throws IllegalArgumentException {
        validateLength(numbers);
        validateDuplicate(numbers);

        this.numbers = numbers;
    }

    private void validateLength(final List<Integer> numbers) throws IllegalArgumentException {
        if (numbers.size() != 6)
            Err.LOTTO_FORMAT_ERROR.invalid();
    }

    private void validateDuplicate(final List<Integer> numbers) throws IllegalArgumentException {
        HashSet<Integer> check = new HashSet<>();
        for (int n: numbers)
            if (!check.add(n))
                Err.DUPLICATE_ERROR.invalid();
    }

    public void check(HashSet<Integer> winning, Integer bonus) {
        int count = 0;
        for (int i = 0; i < 6; ++i)
            if (winning.contains(numbers.get(i)))
                count++;
        if (count == 6)
            Prize.FIRST.incrementCount();
        if (count == 5 && numbers.contains(bonus))
            Prize.SECOND.incrementCount();
        if (count == 5 && !numbers.contains(bonus))
            Prize.THIRD.incrementCount();
        if (count == 4)
            Prize.FOURTH.incrementCount();
        if (count == 3)
            Prize.FIFTH.incrementCount();
    }

    public void print() {
        // sort the lotto numbers when printing
        List<Integer> sorted = new ArrayList<>(numbers);
        Collections.sort(sorted);
        System.out.print('[');
        for (int i = 0; i < sorted.size(); ++i) {
            System.out.print(sorted.get(i));
            if (i != sorted.size() - 1)
                System.out.print(", ");
        }
        System.out.print("]\n");
    }
}
