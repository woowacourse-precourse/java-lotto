package lotto;

import lotto.util.Validate;
import lotto.view.Input;

public class GameProcess {
    public static void gameStart() {
        String payMoney = Input.payMoney();
        Validate.validatePayMoney(payMoney);
    }
}
