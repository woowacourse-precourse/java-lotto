package lotto.controller;

import lotto.model.domain.LottoCollection;
import lotto.model.domain.PayingMoney;
import lotto.model.domain.WinningNumber;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {

    public void run() {
        LottoCollection lottoCollection = buyLotto();

        WinningNumber winningNumber = new WinningNumber(InputView.requestWinningNumber());
        InputView.requestBonusNumber();
    }

    private LottoCollection buyLotto() {
        PayingMoney payingMoney = new PayingMoney(InputView.requestMoney());
        LottoCollection lottoCollection = payingMoney.createLottoCollection();

        OutputView.printLottoCollection(lottoCollection);
        return lottoCollection;
    }

}
