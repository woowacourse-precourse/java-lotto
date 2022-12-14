package lotto.domain;

import java.util.List;

import static lotto.validator.LottoValidator.validateDuplicate;
import static lotto.validator.LottoValidator.validateRange;

public class Lotto {
    private final static String OVER_SIZE_ERROR_MESSAGE = "[ERROR] 로또 번호는 6개입니다.";
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        validateDuplicate(numbers);
        validateRange(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException(OVER_SIZE_ERROR_MESSAGE);
        }
    }

    // TODO: 추가 기능 구현
    public boolean isContain(int number) {
        return numbers.contains(number);
    }

    public int matchCount(Lotto other) {
        int count = 0;
        for (int number : numbers) {
            if (other.isContain(number)) count++;
        }
        return count;
    }

    @Override
    public String toString() {
        return numbers.toString();
    }
}
