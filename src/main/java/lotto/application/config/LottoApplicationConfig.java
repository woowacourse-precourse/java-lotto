package lotto.application.config;

import lotto.domain.lotto.LottoGenerator;
import lotto.domain.money.Money;
import lotto.infra.lotto.RandomsLottoGenerator;

public class LottoApplicationConfig {

    public Money pricePerLotto() {
        return Money.valueOf(1000);
    }

    public LottoGenerator lottoGenerator() {
        return new RandomsLottoGenerator();
    }
}
