package lotto.application.config;

import lotto.controller.LottoController;
import lotto.domain.lotto.LottoGenerator;
import lotto.domain.money.Money;
import lotto.infra.lotto.RandomsLottoGenerator;
import lotto.service.LottoService;

public class LottoApplicationConfig {

    public Money pricePerLotto() {
        return Money.valueOf(1000);
    }

    public LottoGenerator lottoGenerator() {
        return new RandomsLottoGenerator();
    }

    public LottoController lottoController() {
        return new LottoController(lottoService());
    }
    public LottoService lottoService() {
        return new LottoService(pricePerLotto(), lottoGenerator());
    }
}
