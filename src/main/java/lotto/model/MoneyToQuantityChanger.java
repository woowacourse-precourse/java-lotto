package lotto.model;

import static lotto.model.Constants.MONEY_MIN_UNIT;

class MoneyToQuantityChanger {

    public static int change(int money) {
        return money/ MONEY_MIN_UNIT;
    }
}
