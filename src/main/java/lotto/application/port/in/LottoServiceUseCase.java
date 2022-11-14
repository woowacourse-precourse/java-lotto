package lotto.application.port.in;

import lotto.domain.Money;

public interface LottoServiceUseCase {
    ResponseBuyLottoDto buyLotto(String money);


}
