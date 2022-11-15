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
        validateSize(numbers);
        validateDuplicate(numbers);
        validateRange(numbers);
    }

    // TODO: 추가 기능 구현
    private void validateSize(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 로또 번호의 개수는 6개여야 합니다.");
        }
    }

    private void validateDuplicate(List<Integer> numbers) {
        Set<Integer> duplicationSet = new HashSet<>(numbers);
        if (duplicationSet.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 로또 숫자는 중복되어선 안됩니다.");
        }
    }

    private void validateRange(List<Integer> numbers) {
        for (Integer number : numbers) {
            checkRangeOfNumeber(number);
        }
    }

    private static void checkRangeOfNumeber(Integer number) {
        if (number < 1 || 45 < number) {
            throw new IllegalArgumentException("[ERROR] 로또 숫자의 범위는 1부터 45 사이의 숫자여야 합니다.");
        }
    }
}
