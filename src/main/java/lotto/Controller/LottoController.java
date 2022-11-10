package lotto.Controller;

import lotto.View.input;
import lotto.View.output;

public class LottoController {

    public void start() {
        int amountLotto = input.inputMoney();
        output.printAmount(amountLotto);

    }


}
