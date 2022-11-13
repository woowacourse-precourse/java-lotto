package lotto.controller;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;
import lotto.domain.Lotto;
import lotto.domain.Lottos;
import lotto.domain.Money;
import lotto.domain.Result;
import lotto.domain.WinLotto;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoGameController {

    public void run() {
        Money money = Money.from(InputView.getMoneyInput());
        Lottos lottos = createLottos(money.getLottoCnt());
        OutputView.printLottos(lottos, money.getLottoCnt());
        WinLotto winLotto = createWinLotto();
        Result result = Result.of(lottos, winLotto);
        OutputView.printResult(result);
    }

    private Lottos createLottos(int lottoCnt) {
        List<Lotto> lottosList = new ArrayList<>();
        for (int i = 0; i < lottoCnt; i++) {
            lottosList.add(Lotto.from(Randoms.pickUniqueNumbersInRange(1, 45, 6)));
        }
        return Lottos.of(lottosList);
    }

    private WinLotto createWinLotto() {
        return WinLotto.of(Lotto.from(InputView.getWinLotto()), InputView.getBonus());
    }
}
