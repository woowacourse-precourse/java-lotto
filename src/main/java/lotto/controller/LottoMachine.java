package lotto.controller;

import lotto.domain.Lotto;
import lotto.domain.Lottos;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.List;

public class LottoMachine {
    public void purchaseLotto() {
        int money = InputView.insertMoney();
        Lottos lottos = new Lottos(money);
        OutputView.informPurchaseCount(lottos);
        OutputView.printIssuedLottos(lottos);

        List<Integer> winningNumbers = InputView.inputWinningNumbers();
        Lotto winningLotto = new Lotto(winningNumbers);
        int bounsNumber = InputView.inputBounsNumber();

        OutputView.printWinningOverview(lottos, winningLotto, bounsNumber);
    }
}
