package lotto.controller;

import lotto.view.AppView;
import lotto.view.LottoView;

public class AppController {

    public void run() {
        AppView.outputLine("구입금액을 입력해 주세요.");
        int money = LottoView.inputMoney();
    }
}
