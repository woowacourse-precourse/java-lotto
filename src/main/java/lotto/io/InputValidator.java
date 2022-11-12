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
        if (numbers.split(",").length != 6)
            throw new IllegalArgumentException("[ERROR] 당첨 번호는 6개 입력해 주세요.");
    }
}
