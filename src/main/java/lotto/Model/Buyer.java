package lotto.Model;

import lotto.Constant.Message;
import lotto.Utils.Convert;

public class Buyer {

    private static final int THOUSAND_UNIT = 1000;
    private static final int ZERO = 0;
    private final int money;

    public Buyer(final String money) {
        this.money = Convert.StrToInt(money);
        isThousandUnit(this.money);
    }

    private void isThousandUnit(final int money) {
        if (money % THOUSAND_UNIT != ZERO || money == ZERO) {
            throw new IllegalArgumentException(Message.ERROR_THOUSAND_UNIT.getMessage());
        }
    }
}
