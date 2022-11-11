package lotto;

import java.util.List;

public class Lotto {
    private static final int LOTTO_NUMBERS_LENGTH = 6;

    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validateLength(numbers);
        this.numbers = numbers;
    }

    private void validateLength(List<Integer> numbers) {
        if (numbers.size() != LOTTO_NUMBERS_LENGTH) {
            throw new IllegalArgumentException("로또 번호는 " + LOTTO_NUMBERS_LENGTH + "개입니다");
        }
    }

    // TODO: 추가 기능 구현
}
