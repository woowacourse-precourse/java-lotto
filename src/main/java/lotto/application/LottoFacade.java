package lotto.application;

import lotto.domain.*;
import java.util.List;


public class LottoFacade {

    private final LottoProcessor lottoProcessor = new LottoProcessorImpl();
    private final MoneyProcessor moneyProcessor = new MoneyProcessorImpl();


    public List<Lotto> buyLotto(Integer money) {
        Integer count = moneyProcessor.calculateLottoCount(money);
        return lottoProcessor.createLottoByCount(count);
    }
}
