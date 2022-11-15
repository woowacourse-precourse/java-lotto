package lotto;

import static lotto.Error.PRICE_UNIT_ERROR;

public class Purchase {

    public boolean checkPrice(int price) {
        if (price % 1000 != 0) {
            throw new IllegalArgumentException(PRICE_UNIT_ERROR.getMessage());
        }
        return true;
    }
}
