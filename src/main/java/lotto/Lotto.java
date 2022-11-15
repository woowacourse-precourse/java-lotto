package lotto;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import static Constant.ErrorMessage.*;

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
            throw new IllegalArgumentException(LOTTO_DUPLICATE);
        }
    }

    private void checkRange() {
        Utils util = new Utils();
        List<Integer> outRange = numbers.stream()
                .filter(util::invalidRange)
                .collect(Collectors.toList());

        if (outRange.size() != 0) {
            throw new IllegalArgumentException(OUT_RANGE);
        }
    }

    private void checkNumber() {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException(INVALID_NUMBER);
        }
    }

    boolean isHitted(int bonus) {
        return numbers.contains(bonus);
    }

    int countMatchedNumber(Lotto winningLotto) {
        return (int) this.numbers.stream()
                .filter(winningLotto::isHitted)
                .count();
    }

    @Override
    public String toString() {
        return numbers.toString();
    }
}