package lotto;

import static lotto.Error.PRICE_UNIT_ERROR;

public class Purchase {

    public static boolean checkPrice(int price) {
        if (price % 1000 != 0) {
            throw new IllegalArgumentException(PRICE_UNIT_ERROR.getMessage());
        }
        return true;
    }

    public static int getAmount(int price) {
        int amount = price / 1000;
        return amount;
    }
}
