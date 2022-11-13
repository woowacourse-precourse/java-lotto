package lotto.domain;

import java.util.List;

public class Lotto {
    private static final int NUMBERS_SIZE = 6;
    private static final int MIN_RANGE = 1;
    private static final int MAX_RANGE = 45;
    private final List<Integer> numbers;


    public Lotto(List<Integer> numbers) {
        validateDigit(numbers);
        validateDuplication(numbers);
        validateAllRange(numbers);
        this.numbers = numbers;
    }

    private void validateDigit(List<Integer> numbers) {
        if (numbers.size() != NUMBERS_SIZE) {
            throw new IllegalArgumentException();
        }
    }

    private void validateDuplication(List<Integer> numbers) {
        if (numbers.size() != numbers.stream().distinct().count()) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 중복이 없어야 합니다.");
        }

    }

    private void validateAllRange(List<Integer> numbers) {
        for (int num : numbers) {
            validateRange(num);
        }
    }

    private void validateRange(int num) {
        if (num < MIN_RANGE || num > MAX_RANGE) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.");
        }
    }
}
