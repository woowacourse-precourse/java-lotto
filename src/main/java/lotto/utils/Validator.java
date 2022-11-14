package lotto.utils;

public class Validator {
    public static void isBlank(String input) {
        if (input.isBlank()) {
            throw new IllegalArgumentException("[ERROR] 구입금액을 입력해주세요.");
        }
    }

    public static void isNumber(String input) {
        try {
            Integer.parseInt(input);
        } catch (Exception e) {
            throw new IllegalArgumentException("[ERROR] 구입금액은 숫자여야 합니다.");
        }
    }

    public static void isCommaCorrect(String input) {
        if (!input.contains(",")) {
            throw new IllegalArgumentException("[ERROR] 당첨 번호는 콤마(',')로 숫자를 이어서 입력해야 합니다.");
        }
    }

    public static void isAllNumber(String input) {
        String[] inputs = input.split(",");
        for (String digits : inputs) {
            try {
                Integer.valueOf(digits);
            } catch (NumberFormatException e) {
                throw new IllegalArgumentException("[ERROR] 당첨 번호는 숫자여야 합니다.");
            }
        }
    }
}
