package lotto.domain;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validateNumberSize(numbers);
        validateDuplicateNumber(numbers);
        validateNumberRange(numbers);
        this.numbers = numbers;
    }

    private void validateNumberSize(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 6개여야 합니다.");
        }
    }

    private void validateDuplicateNumber(List<Integer> numbers) {
        Set<Integer> notDuplicateNumbers = new HashSet<>(numbers);
        if (notDuplicateNumbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 로또 번호끼리는 중복 될 수 없습니다.");
        }
    }

    private void validateNumberRange(List<Integer> numbers){
        int rightRangeNumberCount = (int)numbers.stream().filter(num -> 1 <= num && num <= 45).count();
        if (rightRangeNumberCount != 6) {
            throw new IllegalArgumentException("[ERROR] 로또 번호의 범위는 1부터 45까지 입니다.");
        }
    }

    public List<Integer> getNumbers() {
        return Collections.unmodifiableList(numbers);
    }
}
