package lotto.exception;

import lotto.constants.Error;
import lotto.constants.Number;

public class PurchaseAmount {
    public static void exceptinoLessThanPrice(String purchaseAmount) {
        if (Integer.parseInt(purchaseAmount) < Number.PRICE.getNumber()) {
            throw new IllegalArgumentException(Error.LESS_THAN_LOTTO_PRICE.getMsg());
        }
    }

    public static void exceptionNoNumber(String purchaseAmount) {
        char check[] = purchaseAmount.toCharArray();
        for (int i = 0; i < check.length; i++) {
            if (!Character.isDigit(check[i])) {
                throw new IllegalArgumentException(Error.WRONG_PURCHASE_AMOUNT_NUM.getMsg());
            }
        }
    }

    public static void exceptionDividePrice(String purchaseAmount) {
        if (Integer.parseInt(purchaseAmount) % Number.PRICE.getNumber() != 0) {
            throw new IllegalArgumentException(Error.WRONG_PURCHASE_AMOUNT_UNIT.getMsg());
        }
    }
}
