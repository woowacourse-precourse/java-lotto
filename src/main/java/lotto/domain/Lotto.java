package lotto.domain;

import java.util.List;

public class Lotto {
    private static final int LOTTO_NUMBER_SIZE = 6;
    private static final String ERROR_WRONG_LOTTO_SIZE = "[ERROR] 당첨 번호 6개를 입력해주세요.";

    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != LOTTO_NUMBER_SIZE) {
            throw new IllegalArgumentException(ERROR_WRONG_LOTTO_SIZE);
        }
    }

    public List<Integer> getNumbers() {
        return numbers;
    }
}
