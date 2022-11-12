package lotto.controller;

import java.util.List;
import lotto.model.domain.Lotto;
import lotto.model.domain.Lottos;
import lotto.model.domain.PayingMoney;
import lotto.model.domain.WinningNumber;
import lotto.model.domain.WinningStatistics;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {

    public void run() {
        Lottos lottos = buyLotto();
        WinningNumber winningNumber = winnerAnnouncement();

        computeWinningStatistics(lottos.get(), winningNumber);
    }

    private Lottos buyLotto() {
        String money = InputView.requestMoney();
        PayingMoney payingMoney = new PayingMoney(money);
        Lottos lottos = payingMoney.createLottos();

        OutputView.printLottos(lottos);
        return lottos;
    }

    private WinningNumber winnerAnnouncement() {
        String winningNumber = InputView.requestWinningNumber();
        String bonusNumber = InputView.requestBonusNumber();

        return new WinningNumber(winningNumber, bonusNumber);
    }

    private void computeWinningStatistics(List<Lotto> lottos, WinningNumber winningNumber) {
        WinningStatistics winningStatistics = new WinningStatistics(lottos, winningNumber);

        OutputView.printWinningStatistics(winningStatistics.get());
        OutputView.printTotalYield(winningStatistics.computeTotalYield());
    }

}
