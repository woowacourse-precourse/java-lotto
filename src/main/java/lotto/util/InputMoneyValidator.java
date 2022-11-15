package lotto.util;

public class InputMoneyValidator {
    private static final int MONEY_UNIT = 1000;

    public static void validateMoneyUnit(Integer money) {
        int remainder = money % MONEY_UNIT;
        if (remainder != 0) throw new IllegalArgumentException("입력 금액이 1000원 단위이어야 합니다.");
    }

    public static void validateMoneyRange(Integer money) {
        if (money < 0 ) throw new IllegalArgumentException("입력 금액이 양수이어야 합니다.");
    }
}