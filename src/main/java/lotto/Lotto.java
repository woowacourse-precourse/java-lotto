package lotto;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (checkSize(numbers) || checkOverlap(numbers) || checkOutOfRange(numbers)) {
            throw new IllegalArgumentException();
        }
    }

    private boolean checkSize(List<Integer> numbers) {
        return numbers.size() != 6;
    }

    private boolean checkOverlap(List<Integer> numbers) {
        Set<Integer> removeOverlap = new HashSet<>(numbers);
        return numbers.size() != removeOverlap.size();
    }

    private boolean checkOutOfRange(List<Integer> numbers) {
        for (Integer number : numbers) {
            if (number > 45 || number < 1) {
                return true;
            }
        }
        return false;
    }

    public List<Integer> getLottoNumbers() {
        return this.numbers;
    }

}
