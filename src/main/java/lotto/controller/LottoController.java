package lotto.controller;

import lotto.domain.LottoMachine;
import lotto.view.InputView;

public class LottoController {

    public void start() {
        LottoMachine lottoMachine = new LottoMachine(InputView.inputPurchasePrice());
        int round = lottoMachine.getRound();
    }
}
