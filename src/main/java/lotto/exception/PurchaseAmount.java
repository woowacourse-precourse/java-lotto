package lotto.exception;

import lotto.constants.Error;
import lotto.constants.Number;

public class PurchaseAmount {
    public static void exceptinoLessThanPrice(String purchaseAmount) {
        if (Integer.parseInt(purchaseAmount) < Number.PRICE.getNumber()) {
            throw new IllegalArgumentException(Error.LESS_THAN_LOTTO_PRICE.getMsg());
        }
    }


}
