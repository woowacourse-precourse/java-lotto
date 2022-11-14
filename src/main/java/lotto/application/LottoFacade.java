package lotto.application;

import lotto.domain.Lotto;
import lotto.domain.LottoEnum;
import lotto.domain.PriceEnum;

import java.util.List;

public interface LottoFacade {
     List<Lotto> buyLotto(Integer money);

     Lotto registerWinLotto(String input);

     String getMargin(Integer before, Integer after);
}
