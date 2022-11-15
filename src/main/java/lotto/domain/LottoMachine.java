package lotto.domain;

import lotto.util.LottoAutoGenerator;

import java.util.ArrayList;
import java.util.List;

import static lotto.domain.LottoSetting.LOTTO_PRICE;
import static lotto.exception.LottoMachineExceptionMessage.MACHINE_NOT_ENOUGH_CASH;

public class LottoMachine {
    private final Cash cash;

    public LottoMachine(Cash cash) {
        this.cash = cash;
    }

    public Lottos purchaseLottos() {
        validateEnoughCash(cash);
        List<Lotto> lottos = new ArrayList<>();
        while (cash.afford(LOTTO_PRICE.getSetting())) {
            cash.spend(LOTTO_PRICE.getSetting());
            lottos.add(LottoAutoGenerator.generate());
        }
        return new Lottos(lottos);
    }

    private void validateEnoughCash(Cash cash) {
        if (!cash.afford(LOTTO_PRICE.getSetting())) {
            throw new IllegalArgumentException(MACHINE_NOT_ENOUGH_CASH.getMessage());
        }
    }

}
