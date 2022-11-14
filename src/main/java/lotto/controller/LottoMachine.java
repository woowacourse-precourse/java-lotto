package lotto.controller;

import lotto.domain.Lotto;
import lotto.domain.Lottos;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.List;

public class LottoMachine {
    public void run() {
        Lottos purchasedLotto = purchaseLottos();
        printInformationOf(purchasedLotto);

        Lotto winningLotto = getWinningLotto();
        int bonusNumber = getBonusNumber();

        OutputView.printWinningOverview(purchasedLotto, winningLotto, bonusNumber);
    }

    private static int getBonusNumber() {
        return InputView.insertBounsNumber();
    }

    private static Lotto getWinningLotto() {
        List<Integer> winningNumbers = InputView.insertWinningNumbers();

        return Lotto.of(winningNumbers);
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
