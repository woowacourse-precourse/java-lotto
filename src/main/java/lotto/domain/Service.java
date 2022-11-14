package lotto.domain;

import lotto.util.Validator;
import lotto.view.Input;
import lotto.view.Output;

public class Service {

    public static void inputMoney() {
        Output.gameStart();
        String payMoney = Input.input();
        Validator.validatePayMoney(payMoney);
        Output.countLotto(payMoney);
    }

}
