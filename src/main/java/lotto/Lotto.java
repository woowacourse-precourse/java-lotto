package lotto;

import java.util.*;
import lotto.UI.Error;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        Collections.sort(numbers);
        this.numbers = numbers;
    }
    public boolean checkDuplicated(List<Integer> numbers) {
        HashSet<Integer> duplicatesExcluded = new HashSet<>(numbers);
        if (duplicatesExcluded.size() != 6)
            return true;
        return false;
    }
    public boolean checkRange(List<Integer> numbers) {
        for (Integer number : numbers) {
            if (number < 1 || number > 45)
                return false;
        }
        return true;
    }
    private void validate(List<Integer> numbers) {
        Error error = new Error();

        if (checkDuplicated(numbers)) {
            error.duplicated();
        }
        if (!checkRange(numbers)) {
            error.outOfRange();
        }
    }
    public void print() {
        System.out.println(numbers);
    }
}
