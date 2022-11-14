package lotto.application;

import lotto.domain.*;
import java.util.List;


public class LottoFacade {

    private final LottoProcessor lottoProcessor = new LottoProcessorImpl();
    private final MoneyProcessor moneyProcessor = new MoneyProcessorImpl();
    private final ValidatorProcessor validatorProcessor = new ValidatorProcessorImpl();


    public List<Lotto> buyLotto(Integer money) {
        validatorProcessor.validateMoney(money, PriceEnum.LOTTO_PRICE);
        Integer count = moneyProcessor.calculateLottoCount(money);
        return lottoProcessor.createLottoByCount(count);
    }
}
