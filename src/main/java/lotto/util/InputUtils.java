package lotto.util;

public class InputUtils {

    private static final int LOTTO_PRICE = 1_000;

    public static void validatePurchaseAmount(int purchaseAmount) {
        if (purchaseAmount % LOTTO_PRICE != 0) {
            throw new IllegalArgumentException();
        }
    }
}
