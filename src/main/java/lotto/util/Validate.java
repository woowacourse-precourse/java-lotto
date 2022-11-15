package lotto.util;

public class Validate {
    public static void isEmpty(String input) {
        if (input.isEmpty()) {
            throw new IllegalArgumentException("[ERROR] 값을 입력해 주세요.");
        }
    }

    public static void isNumber(String input) {
        try {
            Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 숫자가 아닙니다.");
        }
    }
}
