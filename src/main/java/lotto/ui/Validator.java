package lotto.ui;

import java.util.List;

public class Validator {
    private static final int START_NUMBER = 1;
    private static final int END_NUMBER = 45;

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
                throw new IllegalArgumentException("[ERROR] 로또 번호는 1부터 ~ 45 사이의 숫자여야 합니다.");
            }
        }
        return true;
    }

    private static boolean isInRange(int number) {
        return START_NUMBER <= number && number <= END_NUMBER;
    }

    public static boolean isDuplicate(List<Integer> numbers) {
        int count = (int) numbers.stream().distinct().count();

        if (count != numbers.size()) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 중복될 수 없습니다.");
        }
        return false;
    }
}
