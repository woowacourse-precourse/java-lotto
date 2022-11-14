package lotto.controller;

import lotto.domain.Lottos;
import lotto.domain.WinningNumber;
import lotto.service.LottoService;

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
