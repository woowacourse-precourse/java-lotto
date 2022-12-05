package lotto.domain;

import static lotto.util.message.ExceptionMessage.IS_NEGATIVE;
import static lotto.util.message.ExceptionMessage.WRONG_FORMAT;
import static lotto.util.NumericProperties.ONE_THOUSAND;

public class PurchaseAmount {

    private static int purchaseAmount;

    public static void validate(int purchaseAmount1) {
        purchaseAmount = purchaseAmount1;
        if (purchaseAmount < 0) {
            throw new IllegalArgumentException(IS_NEGATIVE.get());
        }
        if (purchaseAmount % ONE_THOUSAND.get() != 0) {
            throw new IllegalArgumentException(WRONG_FORMAT.get());
        }
    }

    public static int getNumberOfLotto() {
        return purchaseAmount / ONE_THOUSAND.get();
    }

    public static float calculateRate(int sum) {
        return sum / (float) purchaseAmount * 100;
    }
}
