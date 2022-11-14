package lotto.Model;

import lotto.Utils.Convert;

public class Buyer {

    private final int money;

    public Buyer(final String money) {
        this.money = Convert.StrToInt(money);
    }
}
