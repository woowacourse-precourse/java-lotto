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
        Lottos lottos = lottoService.buyLotto();
        WinningNumber winningNumber = lottoService.winnerAnnouncement();

        lottoService.computeWinningStatistics(lottos.get(), winningNumber);
    }
}
