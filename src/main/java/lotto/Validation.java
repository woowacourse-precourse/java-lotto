package lotto;

import java.util.HashSet;
import java.util.List;

public class Validation {
    public Validation(List<Integer> numbers){
        isLottoDuplicate(numbers);
        isLottoBetween1And45(numbers);
    }

    public Validation(String number){
        isIncludeNotNumber(number);
        isMultipleOf1000(number);
    }

    private void isLottoBetween1And45(List<Integer> numbers) {
        for (int number : numbers) {
            isNumberBetween1And45(number);
        }
    }

    public void isNumberBetween1And45(int number) throws IllegalArgumentException {
        if (number < 1 || number > 45)
            throw new IllegalArgumentException(Notification.ERROR_MESSAGE_NUMBER_IS_NOT_BETWEEN_1_AND_45.getMessage());
    }

    private void isLottoDuplicate(List<Integer> numbers) throws IllegalArgumentException {
        HashSet<Integer> set = new HashSet<>(numbers);
        if (set.size() != 6)
            throw new IllegalArgumentException(Notification.ERROR_MESSAGE_NUMBER_IS_DUPLICATE.getMessage());
    }

    public static void isIncludeNotNumber(String number) throws IllegalArgumentException {
        String result = number.replaceAll("[0-9]", "");
        if (result.length() != 0)
            throw new IllegalArgumentException(Notification.ERROR_MESSAGE_MONEY_IS_NOT_MULTIPLE_1000.getMessage());
    }

    private static void isMultipleOf1000(String number) throws IllegalArgumentException {
        if (Long.parseLong(number) % 1000 != 0)
            throw new IllegalArgumentException(Notification.ERROR_MESSAGE_MONEY_IS_NOT_MULTIPLE_1000.getMessage());
    }

    public static void isBonusInLotto(List<Integer> numbers, int bonus) throws IllegalArgumentException {
        if (numbers.contains(bonus))
            throw new IllegalArgumentException(Notification.ERROR_MESSAGE_BONUS_IN_LOTTO.getMessage());
    }
}