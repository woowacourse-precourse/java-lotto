package lotto;

import java.util.HashSet;
import java.util.List;

public class Validation {
    public Validation(List<Integer> numbers){
        isLottoDuplicate(numbers);
        isLottoBetween1And45(numbers);
    }

    private void isLottoBetween1And45(List<Integer> numbers) throws IllegalArgumentException {
        for (int number : numbers) {
            if (number < 1 || number > 45)
                throw new IllegalArgumentException(Notification.ERROR_MESSAGE_NUMBER_IS_NOT_BETWEEN_1_AND_45.getMessage());
        }
    }

    private void isLottoDuplicate(List<Integer> numbers) throws IllegalArgumentException {
        HashSet<Integer> set = new HashSet<>(numbers);
        if (set.size() != 6)
            throw new IllegalArgumentException(Notification.ERROR_MESSAGE_NUMBER_IS_DUPLICATE.getMessage());
    }

    public static boolean isMultipleOf1000(long number) throws IllegalArgumentException {
        if (number % 1000 != 0)
            throw new IllegalArgumentException(Notification.ERROR_MESSAGE_MONEY_IS_NOT_MULTIPLE_1000.getMessage());
        return true;
    }

    public static boolean isBonusInLotto(List<Integer> numbers, int bonus) throws IllegalArgumentException {
        if (numbers.contains(bonus))
            throw new IllegalArgumentException(Notification.ERROR_MESSAGE_BONUS_IN_LOTTO.getMessage());
        return true;
    }
}