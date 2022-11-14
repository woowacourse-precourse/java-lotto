package lotto.domain.lottery;

import static lotto.constant.SystemValue.LOTTERY_NUMBERS_SIZE;

import java.util.List;
import java.util.function.Predicate;

public class Lotto {

    private static final String USER_LOTTERY_NUMBERS_SIZE_ERROR = "로또 번호는 6자리여야 합니다";
    private static final String USER_LOTTERY_NUMBERS_CONFLICT_ERROR = "로또 번호에 중복이 포함될 수 없습니다";
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        checkSizeValid(numbers);
        checkConflictValid(numbers);
    }

    public int getMatchCount(List<Integer> winningNumbers) {
        long matchCount = numbers.stream()
                .filter(number -> winningNumbers.stream().anyMatch(Predicate.isEqual(number)))
                .count();
        return Long.valueOf(matchCount).intValue();
    }

    public boolean hasBonusNumber(int bonusNumber) {
        return numbers.contains(bonusNumber);
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

    @Override
    public String toString() {
        return numbers.toString();
    }
}
