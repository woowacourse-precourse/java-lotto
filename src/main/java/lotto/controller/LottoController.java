package lotto.controller;

import java.util.List;
import lotto.model.domain.Lotto;
import lotto.model.domain.LottoCollection;
import lotto.model.domain.PayingMoney;
import lotto.model.domain.WinningNumber;
import lotto.model.domain.WinningStatistics;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {

    public void run() {
        LottoCollection lottoCollection = buyLotto();
        WinningNumber winningNumber = winnerAnnouncement();

        computeWinningStatistics(lottoCollection.get(), winningNumber);
    }

    private LottoCollection buyLotto() {
        String money = InputView.requestMoney();
        PayingMoney payingMoney = new PayingMoney(money);
        LottoCollection lottoCollection = payingMoney.createLottoCollection();

        OutputView.printLottoCollection(lottoCollection);
        return lottoCollection;
    }

    private WinningNumber winnerAnnouncement() {
        String winningNumber = InputView.requestWinningNumber();
        String bonusNumber = InputView.requestBonusNumber();

        return new WinningNumber(winningNumber, bonusNumber);
    }

    private void computeWinningStatistics(List<Lotto> lottoCollection, WinningNumber winningNumber) {
        WinningStatistics winningStatistics = new WinningStatistics(lottoCollection, winningNumber);

        OutputView.printWinningStatistics(winningStatistics.get());
        OutputView.printTotalYield(winningStatistics.computeTotalYield());
    }

}
