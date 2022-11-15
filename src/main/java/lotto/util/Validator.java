package lotto.util;

import java.util.List;

public class Validator {
    private static final String MONEY_NOT_NUMBER = "[ERROR] 구매 금액은 숫자여야 합니다.";
    private static final int START_NUMBER = 1;
    private static final int END_NUMBER = 45;
    private static final int UNIT = 1000;

    public static boolean isNumber(String input) {
        try {
            int money = Integer.parseInt(input);
        } catch (NumberFormatException numberFormatException) {
            throw new IllegalArgumentException(MONEY_NOT_NUMBER);
        }
        return true;
    }

    public static boolean isInRange(List<Integer> numbers) {
        for (int number : numbers) {
            if (!isInRange(number)) {
                return false;
            }
        }
        return true;
    }

    public static boolean isInRange(int number) {
        return START_NUMBER <= number && number <= END_NUMBER;
    }

    public static boolean isDuplicate(List<Integer> numbers) {
        int count = (int) numbers.stream().distinct().count();

        return count != numbers.size();
    }

    public static boolean isDuplicate(List<Integer> numbers, int number) {
        return numbers.contains(number);
    }

    public static boolean isHundredUnit(int money) {
        return money > 0 && (money % UNIT == 0);
    }
}
