package lotto.util;

public class Validator {

    private static final int UNIT_STANDARD = 1000;
    private static final int ZERO = 0;

    private static final String PURCHASE_AMOUNT_UNIT_ERROR_MESSAGE = "구입금액은 1,000원 단위여야 합니다.";

    public static void validateUnitStandard(int purchaseAmount) {
        boolean isPurchaseAmountNotFollowUnitStandard = purchaseAmount % UNIT_STANDARD != ZERO;
        if (isPurchaseAmountNotFollowUnitStandard) {
            throw new IllegalArgumentException(PURCHASE_AMOUNT_UNIT_ERROR_MESSAGE);
        }
    }
}
