package lotto.util;

import lotto.controller.LottoController;
import lotto.service.LottoService;
import lotto.view.Input;

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
