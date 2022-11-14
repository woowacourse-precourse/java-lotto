package lotto;

import org.w3c.dom.ranges.RangeException;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        this.numbers = numbers;
        validate();
    }

    private void validate() {
        checkDuplicate();
        checkRange();
        checkNumber();
    }

    private void checkDuplicate() {
        Set<Integer> set = new HashSet<>(numbers);

        if (set.size() != numbers.size()) {
            throw new IllegalArgumentException();
        }
    }

    private void checkRange() {
        List<Integer> outRange = numbers.stream()
                .filter(number -> number < 1 || number > 45)
                .collect(Collectors.toList());

        if (outRange.size() != 0) {
            throw new IllegalArgumentException();
        }
    }

    private void checkNumber() {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 개수 이상");
        }
    }

    boolean hasNumber(int bonus) {
        return numbers.contains(bonus);
    }

    int countMatchedNumber(Lotto winningLotto) {
        return (int) this.numbers.stream()
                .filter(winningLotto::hasNumber)
                .count();
    }

    @Override
    public String toString() {
        return numbers.toString();
    }
}
