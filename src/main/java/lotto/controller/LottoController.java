package lotto.controller;

import java.util.List;
import lotto.domain.Lotto;
import lotto.domain.LottoIssueMachine;
import lotto.domain.LottoNumber;
import lotto.domain.Money;
import lotto.domain.WinningResult;
import lotto.domain.WinningStatistics;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {
    public void run() {
        try {
            Money money = InputView.inputMoney();
            List<Lotto> lottos = buyLottos(money);
            Lotto winningNumbers = InputView.inputWinningNumbers();
            LottoNumber bonusNumber = InputView.inputBonusNumber();
            WinningStatistics winningStatistics = compieWinningStatistics(lottos, winningNumbers, bonusNumber);
            OutputView.printYield(money, winningStatistics);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }

    private static WinningStatistics compieWinningStatistics(List<Lotto> lottos, Lotto winningNumbers,
                                                             LottoNumber bonusNumber) {
        WinningResult winningResult = new WinningResult(winningNumbers, bonusNumber);
        WinningStatistics winningStatistics = winningResult.compileStatistics(lottos);
        OutputView.printWinningStatistics(winningStatistics);
        return winningStatistics;
    }

    private static List<Lotto> buyLottos(Money money) {
        List<Lotto> lottos = LottoIssueMachine.issue(money.calculateQuantity());
        OutputView.printLottos(lottos);
        return lottos;
    }
}
