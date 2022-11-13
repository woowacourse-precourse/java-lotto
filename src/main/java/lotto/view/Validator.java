package lotto.view;

public class Validator {

    private static final String PATTERN_PURCHASE_AMOUNT = "^[0-9]+$";
    public static final String ERR_PURCHASE_AMOUNT = "[ERROR] 구매 금액은 1000원 단위여야 합니다. 예시) 7000(O), 15000(O), 6500(X)";

    public static void validatePurchaseAmount(String purchaseAmount) {
        if (!purchaseAmount.matches(PATTERN_PURCHASE_AMOUNT)) {
            throw new IllegalArgumentException(ERR_PURCHASE_AMOUNT);
        }
    }
}
