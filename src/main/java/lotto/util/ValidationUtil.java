package lotto.util;

public class ValidationUtil {

    public static boolean validatePositiveNum(int purchaseAmountInput) {
        return purchaseAmountInput > 0;
    }

    public static boolean validateRemainder(int purchaseAmountInput) {
        return purchaseAmountInput % 1000 == 0;
    }
}
