package lotto;

import org.assertj.core.util.Lists;
import org.assertj.core.util.Sets;

import java.util.Comparator;
import java.util.List;
import java.util.Set;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        checkOverlap(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException();
        }
    }

    // TODO: 추가 기능 구현
    private void checkOverlap(List<Integer> numbers) {
        Set<Integer> overlapRemove = Sets.newHashSet(numbers);
        if (overlapRemove.size() != 6) {
            throw new IllegalArgumentException();
        }
    }
}
