package lotto.application;

import lotto.domain.lotto.Lottos;
import lotto.domain.lotto.service.LottoService;
import lotto.domain.money.Money;
import lotto.domain.money.service.MoneyService;

public class LottoFacade {

    private final LottoService lottoService;
    private final MoneyService moneyService;

    public LottoFacade(LottoService lottoService, MoneyService moneyService) {
        this.lottoService = lottoService;
        this.moneyService = moneyService;
    }

    public Money createMoney() {
        final String inputMoney = lottoService.requestMoney();
        return moneyService.createMoney(inputMoney);
    }

    public Lottos buyLottos(Money money) {
        final Lottos lottos = lottoService.buyLottos(money);
        lottoService.sendLottosInfo(lottos);
        return lottos;
    }
}
