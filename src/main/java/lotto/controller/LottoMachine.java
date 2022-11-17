package lotto.controller;

import lotto.domain.Lotto;
import lotto.domain.Lottos;
import lotto.domain.Money;
import lotto.domain.WinningLotto;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.List;

public class LottoMachine {
    private final OutputView outputView;

    public LottoMachine() {
        outputView = new OutputView();
    }

    public void run() {
        Lottos purchasedLotto = purchaseLottos();
        printInformationOf(purchasedLotto);

        WinningLotto winningLotto = getWinningLotto();

        outputView.printWinningOverview(purchasedLotto, winningLotto);
    }

    private static Lottos purchaseLottos() {
        Money money = InputView.insertMoney();

        return Lottos.purchaseFor(money);
    }

    private void printInformationOf(Lottos lottos) {
        outputView.informPurchaseCount(lottos);
        outputView.printIssuedLottos(lottos);
    }

    private static WinningLotto getWinningLotto() {
        List<Integer> winningNumbers = InputView.insertWinningNumbers();
        Lotto lotto = Lotto.of(winningNumbers);
        int bonusNumber = InputView.insertBonusNumber();

        return WinningLotto.of(lotto, bonusNumber);
    }
}
