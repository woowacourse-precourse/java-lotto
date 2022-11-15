package lotto.service;

import lotto.domain.*;

public class LottoGameService {

    private Lottos lottos;

    public void buyLottos(int inputMoney) {
        Money money = new Money(inputMoney);
        LottoFactory factory = new LottoFactory(new RandomNumbers());
        this.lottos = new Lottos(factory.generateLottos(money));
    }

    public int getLottosSize() {
        return lottos.size();
    }

    public String getLottosToString() {
        return lottos.toString();
    }

}
