package lotto.service;

import lotto.domain.LottoFactory;
import lotto.domain.Lottos;
import lotto.domain.Money;
import lotto.domain.RandomNumbers;

public class LottoGameService {

    private Lottos lottos;

    public void buyLottos(int inputMoney) {
        Money money = new Money(inputMoney);
        LottoFactory factory = new LottoFactory(new RandomNumbers());
        this.lottos = new Lottos(factory.generateLottos(money));
    }
}
