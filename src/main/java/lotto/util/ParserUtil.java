package lotto.util;


public class ParserUtil {

    public static int parsePurchaseAmountInput(String purchaseAmountInput) {
        int purchaseAmount = Integer.parseInt(purchaseAmountInput);

        if (!ValidationUtil.validatePositiveNum(purchaseAmount)) {
            throw new IllegalArgumentException();
        }
        if (!ValidationUtil.validateRemainder(purchaseAmount)) {
            throw new IllegalArgumentException();
        }

        return purchaseAmount;
    }



}
