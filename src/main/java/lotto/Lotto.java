package lotto;

import lotto.Utils.Error;

import java.util.*;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        Collections.sort(numbers);
        this.numbers = numbers;
    }
    private void checkDuplicated(List<Integer> numbers) {
        HashSet<Integer> duplicatesExcluded = new HashSet<>(numbers);
        if (duplicatesExcluded.size() != 6) {
            Error.duplicated();
        }
    }
    private void checkRange(List<Integer> numbers) {
        for (Integer number : numbers) {
            if (number < 1 || number > 45) {
                Error.outOfRange();
            }
        }
    }
    private void validate(List<Integer> numbers) {
        checkDuplicated(numbers);
        checkRange(numbers);
    }
    public void print() {
        System.out.println(numbers);
    }
}
