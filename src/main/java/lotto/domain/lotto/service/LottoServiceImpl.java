package lotto.domain.lotto.service;

import lotto.domain.lotto.Lottos;
import lotto.domain.money.Money;

public class LottoServiceImpl implements LottoService {

    private final LottoMessenger lottoMessenger;
    private final LottoCreator lottoCreator;

    public LottoServiceImpl(LottoMessenger lottoMessenger, LottoCreator lottoCreator) {
        this.lottoMessenger = lottoMessenger;
        this.lottoCreator = lottoCreator;
    }

    @Override
    public String requestMoney() {
        return lottoMessenger.requestMoney();
    }

    @Override
    public Lottos buyLottos(Money money) {
        return lottoCreator.buyLottos(money);
    }

    @Override
    public void sendLottosInfo(Lottos lottos) {
        lottoMessenger.sendLottosInfo(lottos);
    }

}
