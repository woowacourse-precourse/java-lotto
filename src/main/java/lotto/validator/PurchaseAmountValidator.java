package lotto.validator;

public class PurchaseAmountValidator {
    public static void validate(String money) {
        if (!isDigit(money)) {
            throw new IllegalArgumentException("[ERROR] 올바른 입력이 아닙니다.");
        }
        if (!isCorrectUnit(money)) {
            throw new IllegalArgumentException("[ERROR] 1000원 단위로 입력해야합니다.");
        }
    }

    private static boolean isDigit(String money) {
        return money.chars().allMatch(Character::isDigit);
    }

    private static boolean isCorrectUnit(String money) {
        return Integer.parseInt(money) % 1000 == 0;
    }
}
