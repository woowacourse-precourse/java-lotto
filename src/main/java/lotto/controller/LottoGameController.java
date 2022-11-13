package lotto.controller;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;
import lotto.domain.Lotto;
import lotto.domain.LottoFactory;
import lotto.domain.Lottos;
import lotto.domain.Money;
import lotto.domain.Result;
import lotto.domain.WinLotto;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoGameController {

    public void run() {
        Money money = getMoney();
        Lottos lottos = getLottos(money.getLottoCnt());
        OutputView.printLottos(lottos, money.getLottoCnt());
        WinLotto winLotto = getWinLotto();
        Result result = Result.of(lottos, winLotto);
        OutputView.printResult(result);
        OutputView.printProfit(result.getPrize(),money.get());
    }

    private Money getMoney() {
        return Money.from(InputView.getMoneyInput());
    }

    private Lottos getLottos(int lottoCnt) {
        return LottoFactory.createRandomLottos(lottoCnt);
    }

    private WinLotto getWinLotto() {
        return LottoFactory.createWinLotto(InputView.getWinLotto(),InputView.getBonus());
    }
}
