package lotto.domain.lotto.service;

import lotto.domain.lotto.Lottos;
import lotto.domain.money.Money;

public interface LottoCreator {

    Lottos buyLottos(Money money);
}
