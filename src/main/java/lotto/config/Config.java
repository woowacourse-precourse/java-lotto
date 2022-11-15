package lotto.config;

import lotto.domain.LottoMachine;
import lotto.domain.LottoService;

public class Config {
    public static LottoService lottoService() {
        return new LottoService();
    }

    public static LottoMachine lottoMachine() {
        return new LottoMachine(lottoService());
    }
}
