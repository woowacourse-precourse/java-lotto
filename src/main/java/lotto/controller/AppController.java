package lotto.controller;

import lotto.MyLottos;
import lotto.view.AppView;
import lotto.view.LottoView;

import static lotto.controller.LottoController.*;

public class AppController {
    MyLottos myLottos;

    public void run() {
        AppView.outputLine("구입금액을 입력해 주세요.");
        int money = LottoView.inputMoney();
        AppView.outputLine("");
        myLottos = generateMyLottoInstance(money);

    }
}
