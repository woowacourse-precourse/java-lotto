package lotto.domain;

import java.util.List;

public class Lotto {
    private static final int LOTTO_NUMBER_COUNT = 6;
    private static final String ERROR_NUMBERS_COUNT = "[ERROR] 로또 숫자는 6개여야 합니다.";

    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != LOTTO_NUMBER_COUNT) {
            throw new IllegalArgumentException(ERROR_NUMBERS_COUNT);
        }
    }

    // TODO: 추가 기능 구현
}
