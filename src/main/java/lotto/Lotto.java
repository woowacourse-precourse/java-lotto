package lotto;

import java.util.HashSet;
import java.util.List;
import java.util.Set;


public class Lotto {
    private static final int INIT = 0;
    private static final int CNT_NUMBER = 6;
    private static final int MIN_NUMBER = 1;
    private static final int MAX_NUMBER = 45;

    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        validateDuplicate(numbers);
        validateRange(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != CNT_NUMBER) {
            throw new IllegalArgumentException("[ERROR] 로또 번호의 개수가 6개가 아닙니다.");
        }
    }

    private void validateDuplicate(List<Integer> numbers) {
        Set<Integer> checkDuplicate = new HashSet<>(numbers);
        if (numbers.size() != checkDuplicate.size()) {
            throw new IllegalArgumentException("[ERROR] 로또 번호 중 중복 숫자가 존재합니다.");
        }
    }

    private void validateRange(List<Integer> numbers) {
        for (int i = INIT; i < numbers.size(); i++) {
            if (numbers.get(i) < MIN_NUMBER || numbers.get(i) > MAX_NUMBER) {
                throw new IllegalArgumentException("[ERROR] 범위를 초과한 숫자가 존재합니다.");
            }
        }
    }

}
