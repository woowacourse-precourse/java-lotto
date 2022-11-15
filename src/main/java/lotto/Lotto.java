package lotto;

import java.util.Comparator;
import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
        sortByAsc();
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException();
        }

        if (!isDifferentNumbers(numbers)) {
            throw new IllegalArgumentException();
        }
    }

    private boolean isDifferentNumbers(List<Integer> numbers) {
        Set<Integer> numSet = new HashSet<>(numbers);
        if (numbers.size() != numSet.size()) {
            return false;
        }
        return true;
    }

    public void sortByAsc() {
        this.numbers.sort(Comparator.naturalOrder());
    }
}
