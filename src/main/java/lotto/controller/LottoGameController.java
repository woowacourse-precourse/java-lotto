package lotto.controller;

import lotto.domain.lotto.LottoFactory;
import lotto.domain.lotto.Lottos;
import lotto.domain.statistics.Money;
import lotto.domain.statistics.Result;
import lotto.domain.lotto.WinLotto;
import lotto.domain.statistics.Yield;
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
