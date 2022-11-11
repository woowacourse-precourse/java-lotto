package lotto;

import java.util.List;

public class Lotto {
    private static final int MAX = 6;
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        checkDuplicate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != MAX) {
            throw new IllegalArgumentException();
        }
    }

    private void checkDuplicate(List<Integer> numbers) {
        if (numbers.stream().distinct().findFirst().isPresent()) {
            throw new IllegalArgumentException("[ERROR] 중복된 숫자를 입력했습니다.");
        }
    }
}
