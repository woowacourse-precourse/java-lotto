package lotto;

public class AmountValidator {

    private static final int CURRENCY_UNIT = 1000;

    private AmountValidator() {
    }

    public static void validate(int amount) {
        validatePositive(amount);
        validateCurrencyUnit(amount);
    }

    private static void validatePositive(int amount) {
        if (amount < 0) {
            throw new IllegalArgumentException("[ERROR] 구입 금액은 양수만 가능합니다.");
        }
    }

    private static void validateCurrencyUnit(int amount) {
        if (amount % CURRENCY_UNIT != 0) {
            throw new IllegalArgumentException("[ERROR] 구입 금액은 1,000원 단위여야 합니다.");
        }
    }
}
