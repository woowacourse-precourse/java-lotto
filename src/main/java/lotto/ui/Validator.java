package lotto.ui;

import java.util.List;

public class Validator {
    private static final int START_NUMBER = 1;
    private static final int END_NUMBER = 45;
    private static final int UNIT = 1000;

    public static boolean isNumber(char input) {
        if (!Character.isDigit(input)) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 숫자여야 합니다.");
        }
        return true;
    }

    public static boolean isNumber(String input) {
        try {
            int money = Integer.parseInt(input);
        } catch (NumberFormatException numberFormatException) {
            throw new IllegalArgumentException("[ERROR] 구매 금액은 숫자여야 합니다.");
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

    private static boolean isInRange(int number) {
        return START_NUMBER <= number && number <= END_NUMBER;
    }

    public static boolean isDuplicate(List<Integer> numbers) {
        int count = (int) numbers.stream().distinct().count();

        return count != numbers.size();
    }

    public static boolean isHundredUnit(int money) {
        if (money > 0 && money % UNIT != 0) {
            throw new IllegalArgumentException("[ERROR] 구매 금액은 1000원 단위여야 합니다.");
        }
        return true;
    }
}
