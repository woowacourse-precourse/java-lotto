package lotto;

public class Validation {

    // 숫자만 입력했는지 검증
    public static void isDigit(String numbers) {
        for (char number : numbers.toCharArray()) {
            if (!Character.isDigit(number)) {
                throw new IllegalArgumentException("숫자만 입력해주세요.");
            }
        }
    }

}
