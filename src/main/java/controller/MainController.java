package controller;

import lotto.LottoStore;
import view.InputView;
import view.OutputView;

public class MainController {

    public void moneyController() {
        int inputMoney = InputView.inputMoney();
        int lottoCount = new LottoStore().calculateLottoCount(inputMoney);
        new OutputView().printLottoCount(lottoCount);
    }
}
