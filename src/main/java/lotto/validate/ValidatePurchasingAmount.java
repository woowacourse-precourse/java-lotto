package lotto.validate;

public class ValidatePurchasingAmount extends Validate {
    public static void validate(String purchasingMoney) throws IllegalArgumentException {
        validateIsNullOrEmpty(purchasingMoney);
        validateEndsWithThreeZeros(purchasingMoney);
        validateIsNumber(purchasingMoney);
    }
}
