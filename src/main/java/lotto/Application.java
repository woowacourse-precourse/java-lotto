package lotto;

import lotto.controller.LottoController;
import lotto.domain.LottoSeller;
import lotto.service.LottoService;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        LottoController lottoController = new LottoController(lottoService());
        lottoController.run();
    }

    private static LottoService lottoService() {
        return new LottoService(lottoSeller());
    }

    private static LottoSeller lottoSeller() {
        return new LottoSeller();
    }
}
