package lotto.domain;

public class Utils {
    public static int textToNumber(String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 구입 금액에는 숫자만 입력해야 합니다.");
        }
    }
}
