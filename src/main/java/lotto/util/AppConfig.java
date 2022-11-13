package lotto.util;

import java.util.List;
import lotto.controller.LottoController;
import lotto.domain.LottoGenerator;
import lotto.domain.LottoList;
import lotto.domain.LottoMachine;
import lotto.domain.Money;
import lotto.domain.WinningLottoNumber;
import lotto.service.LottoService;
import lotto.view.Input;
import lotto.view.Output;

public class AppConfig {
    public LottoController lottoController() {
        return new LottoController(lottoService(), input());
    }

    private LottoService lottoService() {
        return new LottoService();
    }

    private Input input() {
        return new Input();
    }
}
