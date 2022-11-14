package lotto.presentation;

import lotto.application.LottoFacade;
import lotto.domain.lotto.Lottos;
import lotto.domain.money.Money;

public class LottoController {

    private final LottoFacade lottoFacade;

    public LottoController(LottoFacade lottoFacade) {
        this.lottoFacade = lottoFacade;
    }

    public void run() {
        final Money money = lottoFacade.createMoney();
        final Lottos lottos = lottoFacade.buyLottos(money);
    }
}
