package lotto.domain;

import java.util.List;

public class Lotto {
    private final List<Integer> numbers;
    private static final String VALID_LENGTH = "[ERROR] 로또 번호는 6개의 숫자여야 합니다.";

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException(VALID_LENGTH);
        }
    }

    public List<Integer> getLottoNumbers() {
        return numbers;
    }
}
