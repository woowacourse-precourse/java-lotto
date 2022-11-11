package lotto;

import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) throws IllegalArgumentException {
        validateLength(numbers);
        validateDuplicate(numbers);
        Collections.sort(numbers);
        this.numbers = numbers;
    }

    private void validateLength(List<Integer> numbers) throws IllegalArgumentException {
        if (numbers.size() != 6)
            Err.LOTTO_FORMAT_ERROR.invalid();
    }

    private void validateDuplicate(List<Integer> numbers) throws IllegalArgumentException {
        HashSet<Integer> check = new HashSet<>();
        for (int n: numbers) {
            if (check.contains(n))
                Err.DUPLICATE_ERROR.invalid();
            check.add(n);
        }
    }

    // TODO: 추가 기능 구현
}
