package lotto.application.service;

import lotto.application.port.in.LottoServiceUseCase;
import lotto.application.port.in.ResponseBuyLottoDto;
import lotto.domain.Money;

public class LottoService implements LottoServiceUseCase {
    @Override
    public ResponseBuyLottoDto buyLotto(String money) {
        return null;
    }

    private int exchangeMoneyToLotto(Money money) {

    }
}