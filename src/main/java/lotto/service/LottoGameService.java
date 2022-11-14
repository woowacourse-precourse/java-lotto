package lotto.service;

import lotto.domain.Money;

public class LottoGameService {

    public void buyLottos(int inputMoney) {
        Money money = new Money(inputMoney);
        int amount = money.getAmount();
    }
}
