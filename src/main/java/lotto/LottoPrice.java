package lotto;

import static lotto.Error.PRICE_UNIT_ERROR;

public class LottoPrice {

    private static int LOTTO_PRICE = 1000;

    public static boolean checkPrice(int price) {
        if (price % LOTTO_PRICE != 0) {
            throw new IllegalArgumentException(PRICE_UNIT_ERROR.getMessage());
        }
        return true;
    }

    public static int getAmount(int price) {
        return price / LOTTO_PRICE;
    }
}
