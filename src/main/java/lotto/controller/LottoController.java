package lotto.controller;

import lotto.model.domain.LottoCollection;
import lotto.model.domain.PayingMoney;
import lotto.model.domain.WinningNumber;
import lotto.model.domain.WinningStatistics;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {

    public void run() {
        LottoCollection lottoCollection = buyLotto();
        WinningNumber winningNumber = WinnerAnnouncement();
        WinningStatistics winningStatistics = new WinningStatistics(lottoCollection, winningNumber);
    }

    private LottoCollection buyLotto() {
        PayingMoney payingMoney = new PayingMoney(InputView.requestMoney());
        LottoCollection lottoCollection = payingMoney.createLottoCollection();

        OutputView.printLottoCollection(lottoCollection);
        return lottoCollection;
    }

    private WinningNumber WinnerAnnouncement() {
        String winningNumber = InputView.requestWinningNumber();
        String bonusNumber = InputView.requestBonusNumber();

        return new WinningNumber(winningNumber, bonusNumber);
    }

}
