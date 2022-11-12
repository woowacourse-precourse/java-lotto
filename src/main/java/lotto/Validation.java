package lotto;

public class Validation {

    // 숫자만 입력했는지 검증
    public static void isDigit(String numbers) {
        for (char number : numbers.toCharArray()) {
            if (!Character.isDigit(number)) {
                throw new IllegalArgumentException("숫자만 입력해 주세요.");
            }
        }
    }
    // 1000원 단위로 입력했는지 검증
    public static void isThousandUnit(String purchaseAmount) {
        long money = Long.parseLong(purchaseAmount);
        if (money % 1000 != 0) {
            throw new IllegalArgumentException("1000원 단위로 입력해 주세요.");
        }
    }

}
