package lotto.domain;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    public void printNumbers() {
        List<Integer> numbersForSort = new ArrayList<>(numbers);
        numbersForSort.sort(Comparator.naturalOrder());
        System.out.println(numbersForSort);
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException();
        }
    }
}
