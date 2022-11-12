package lotto.io;

public class InputValidator {
    public static void validateToParseInt(String str) {
        try {
            Integer.parseInt(str);
        } catch (Exception e) {
            throw new IllegalArgumentException("[ERROR] 숫자만 입력해 주세요.");
        }
    }

    public static void validateWinningNumbers(String numbers) {
        for (String number : numbers.trim().split(",")) {
            validateToParseInt(number);
        }
    }
}
