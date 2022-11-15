package lotto.domain;

import java.util.List;

public class Lotto {

    private static final int NUMBER_MIN_RANGE = 1;
    private static final int NUMBER_MAX_RANGE = 45;
    private static final String ERR_WRONG_NUMBER_RANGE = "[ERROR] 당첨 번호는 1~45 숫자여야 합니다. ";

    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException();
        }
    }

    public void validateNumberInRange(int number) {
        if (number < NUMBER_MIN_RANGE || NUMBER_MAX_RANGE < number) {
            throw new IllegalArgumentException(ERR_WRONG_NUMBER_RANGE);
        }
    }
}
