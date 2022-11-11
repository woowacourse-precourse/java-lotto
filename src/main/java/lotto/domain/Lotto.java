package lotto.domain;

import static lotto.constant.SystemMessage.USER_LOTTERY_NUMBERS_CONFLICT_ERROR;
import static lotto.constant.SystemMessage.USER_LOTTERY_NUMBERS_SIZE_ERROR;
import static lotto.constant.SystemValue.LOTTERY_NUMBERS_SIZE;

import java.util.List;
import lotto.view.Output;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
        Output.printLotteryNumbers(numbers);
    }

    private void validate(List<Integer> numbers) {
        if (!isSizeValid(numbers) || !isConflictValid(numbers)) {
            throw new IllegalArgumentException();
        }
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    public static boolean isSizeValid(List<Integer> numbers) {
        boolean isSize = numbers.size() == LOTTERY_NUMBERS_SIZE;
        if (!isSize) {
            Output.printError(USER_LOTTERY_NUMBERS_SIZE_ERROR);
        }
        return isSize;
    }

    public static boolean isConflictValid(List<Integer> numbers) {
        boolean isConflict = numbers.stream()
                .distinct()
                .count() == LOTTERY_NUMBERS_SIZE;
        if (!isConflict) {
            Output.printError(USER_LOTTERY_NUMBERS_CONFLICT_ERROR);
        }
        return isConflict;
    }
}
