package lotto.validator;

public class PurchaseAmountValidator {
    public static void validate(String money) {
        if (Integer.parseInt(money) % 1000 != 0) {
            throw new IllegalArgumentException();
        }
        if (money.chars().allMatch(Character::isDigit)) {
            throw new IllegalArgumentException();
        }
    }
}
