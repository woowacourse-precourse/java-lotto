package lotto;

import java.util.List;

public class Lotto {
    private final List<Integer> numbers;
    private static final int NUMBER_SIZE = 6;
    private static final String LOTTO_SIZE_ERROR = "[ERROR] 로또를 발행하기 위해서는 6개의 숫자여야 합니다.";

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != NUMBER_SIZE) {
            throw new IllegalArgumentException(LOTTO_SIZE_ERROR);
        }
    }

    public List<Integer> getNumbers() {
        return numbers;
    }
}
