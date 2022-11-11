package lotto.domain;

import static lotto.constant.SystemMessage.USER_LOTTERY_NUMBERS_CONFLICT_ERROR;
import static lotto.constant.SystemMessage.USER_LOTTERY_NUMBERS_SIZE_ERROR;
import static lotto.constant.SystemValue.LOTTERY_NUMBERS_SIZE;

import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        checkSizeValid(numbers);
        checkConflictValid(numbers);
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    public static void checkSizeValid(List<Integer> numbers) {
        boolean isSize = numbers.size() == LOTTERY_NUMBERS_SIZE;
        if (!isSize) {
            throw new IllegalArgumentException(USER_LOTTERY_NUMBERS_SIZE_ERROR);
        }
    }

    public static void checkConflictValid(List<Integer> numbers) {
        boolean isConflict = numbers.stream()
                .distinct()
                .count() == LOTTERY_NUMBERS_SIZE;
        if (!isConflict) {
            throw new IllegalArgumentException(USER_LOTTERY_NUMBERS_CONFLICT_ERROR);
        }
    }
}
