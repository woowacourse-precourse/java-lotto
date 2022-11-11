package lotto.controller;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;
import lotto.domain.Lotto;
import lotto.domain.Lottos;
import lotto.domain.Money;
import lotto.domain.WinLotto;
import lotto.view.InputView;

public class LottoGameController {

    public void run() {
        Money money = Money.from(InputView.getMoneyInput());
        Lottos lottos = createLottos(money.getLottoCnt());
        WinLotto winLotto = createWinLotto();
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
