package lotto.controller;

import lotto.model.domain.Lottos;
import lotto.model.domain.WinningNumber;
import lotto.model.service.LottoService;

public class LottoController {

    private final LottoService lottoService;

    public LottoController(LottoService lottoService) {
        this.lottoService = lottoService;
    }

    public void run() {
        Lottos lottos = lottoService.createLottos();
        WinningNumber winningNumber = lottoService.createWinnerNumber();

        lottoService.computeWinningStatistics(lottos.get(), winningNumber);
    }
}
