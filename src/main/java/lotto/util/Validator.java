package lotto.util;

import java.util.List;

public class Validator {
    public static final int START_NUMBER = 1;
    public static final int END_NUMBER = 45;
    public static final int LOTTO_SIZE = 6;
    public static final int UNIT = 1000;

    private Validator() {}

    public static boolean isNumber(String input) {
        try {
            int money = Integer.parseInt(input);
        } catch (NumberFormatException numberFormatException) {
            return false;
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

    public static boolean isPositive(int money) {
        return money > 0;
    }

    public static boolean isHundredUnit(int money) {
        return money % UNIT == 0;
    }
}
