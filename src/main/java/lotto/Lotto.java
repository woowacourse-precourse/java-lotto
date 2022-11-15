package lotto;

import java.util.List;

public class Lotto {
    private final List<Integer> numbers;
    private static final int MIN_LOTTO_NUMBER = 1;
    private static final int MAX_LOTTO_NUMBER = 45;
    private static final int LOTTO_LENGTH = 6;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    public List<Integer> getUserLottoNumber() {
        return numbers;
    }

   private void validate(List<Integer> numbers) {
        validateUserInput(numbers);
    }

    private void validateUserInput(List<Integer> numbers) {
        if (numbers.size() != LOTTO_LENGTH) {
            throw new IllegalArgumentException("총 6개의 숫자를 입력하셔야 합니다.")
        }
    }
}

