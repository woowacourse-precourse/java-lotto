package lotto.controller;

import lotto.model.domain.LottoCollection;
import lotto.model.domain.PayingMoney;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {

    public void run() {
        PayingMoney payingMoney = new PayingMoney(InputView.requestMoney());
        LottoCollection lottoCollection = payingMoney.createLottoCollection();

        OutputView.printLottoCollection(lottoCollection);
    }
}
