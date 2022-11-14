package lotto.model;

import java.util.List;

public class Lotto {
    private static final int LOTTO_NUMBER_COUNT = 6;
    private static final String ERROR_INCORRECT_COUNT = "[ERROR] 로또 번호는 1~45까지 중 서로 다른 6자리 수여야 합니다.";
    private static final String ERROR_DUPLICATE = "[ERROR] 로또 번호가 중복입니다.";
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != LOTTO_NUMBER_COUNT) {
            throw new IllegalArgumentException(ERROR_INCORRECT_COUNT);
        }

        if (numbers.size() != numbers.stream().distinct().count()) {
            throw new IllegalArgumentException(ERROR_DUPLICATE);
        }
    }

    // TODO: 추가 기능 구현
    public List<Integer> getNumbers() {
        return this.numbers;
    }
}
