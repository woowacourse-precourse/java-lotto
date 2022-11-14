package lotto;

import java.util.regex.Pattern;

public class LottoView {

    public static void validate(String input) {
        isNull(input);
        isNumber(input);
        isCorrect(input);
    }

    public static void isNull(String input) {
        if (input.isEmpty()) {
            throw new IllegalArgumentException("[ERROR] 숫자를 입력해주세요.");
        }
    }

    public static void isNumber(String input) {
        if (!Pattern.matches("[0-9]+", input)) {
            throw new IllegalArgumentException("[ERROR] 숫자만 입력할 수 있습니다.");
        }
    }

    public static void isCorrect(String input) {
        int cost = Integer.parseInt(input);
        if (cost % 1000 != 0) {
            throw new IllegalArgumentException("[ERROR] 1000원 단위로만 입력이 가능합니다.");
        }
    }
}
