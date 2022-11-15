package lotto;

import java.util.*;

public class Lotto {
    private List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
        // sortByAsc();
    }

    public List<Integer> getNumbers() {
        return numbers;
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

    private void sortByAsc() {
//        this.numbers.sort(Comparator.naturalOrder());
        Collections.sort(numbers);
    }
}
