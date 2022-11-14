package lotto.controller;

import lotto.domain.LottoFactory;
import lotto.domain.Lottos;
import lotto.domain.Money;
import lotto.domain.Result;
import lotto.domain.WinLotto;
import lotto.domain.Yield;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoGameController {

    public void run() {
        Money money = getMoney();
        Lottos lottos = getLottos(money.getLottoCnt());
        OutputView.printLottos(lottos);

        WinLotto winLotto = getWinLotto();
        Result result = Result.of(lottos, winLotto);
        Yield  yield  = Yield.of(money.get(),result.getPrize());
        OutputView.printResult(result);
        OutputView.printYield(yield);
    }

    private Money getMoney() {
        return Money.from(InputView.getMoneyInput());
    }

    private Lottos getLottos(int lottoCnt) {
        return LottoFactory.createRandomLottoByCnt(lottoCnt);
    }

    private WinLotto getWinLotto() {
        return LottoFactory.createWinLotto(InputView.getWinLotto(),InputView.getBonus());
    }
}
