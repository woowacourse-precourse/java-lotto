package lotto.global.config;

import lotto.application.LottoFacade;
import lotto.domain.lotto.service.LottoMessenger;
import lotto.domain.lotto.service.LottoService;
import lotto.domain.lotto.service.LottoServiceImpl;
import lotto.domain.money.service.MoneyFactory;
import lotto.domain.money.service.MoneyService;
import lotto.domain.money.service.MoneyServiceImpl;
import lotto.infrastructure.lotto.LottoMessengerImpl;
import lotto.infrastructure.money.MoneyFactoryImpl;
import lotto.presentation.LottoController;

public class AppConfig {

    public LottoController lottoController() {
        return new LottoController(lottoFacade());
    }

    public LottoFacade lottoFacade() {
        return new LottoFacade(lottoService(), moneyService());
    }

    public LottoService lottoService() {
        return new LottoServiceImpl(lottoMessenger());
    }

    public LottoMessenger lottoMessenger() {
        return new LottoMessengerImpl();
    }

    public MoneyService moneyService() {
        return new MoneyServiceImpl(moneyFactory());
    }

    public MoneyFactory moneyFactory() {
        return new MoneyFactoryImpl();
    }
}
