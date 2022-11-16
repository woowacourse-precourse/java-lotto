package lotto.controller;

import lotto.domain.Lotto;
import lotto.domain.Lottos;
import lotto.domain.WinningLotto;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.List;

public class LottoMachine {
    public void run() {
        Lottos purchasedLotto = purchaseLottos();
        printInformationOf(purchasedLotto);

        WinningLotto winningLotto = getWinningLotto();

        OutputView.printWinningOverview(purchasedLotto, winningLotto);
    }

    private static int getBonusNumber() {
        return InputView.insertBonusNumber();
    }

    private static WinningLotto getWinningLotto() {
        List<Integer> winningNumbers = InputView.insertWinningNumbers();
        Lotto lotto = Lotto.of(winningNumbers);
        int bonusNumber = InputView.insertBonusNumber();

        return WinningLotto.of(lotto, bonusNumber);
    }

    private static void printInformationOf(Lottos lottos) {
        OutputView.informPurchaseCount(lottos);
        OutputView.printIssuedLottos(lottos);
    }

    private static Lottos purchaseLottos() {
        int money = InputView.insertMoney();

        return Lottos.purchaseFor(money);
    }
}
