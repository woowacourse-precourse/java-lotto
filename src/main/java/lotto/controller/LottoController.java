package lotto.controller;

import java.util.List;
import lotto.domain.Lotto;
import lotto.domain.WinningLotto;
import lotto.service.InputService;
import lotto.service.LottoService;
import lotto.service.WinningStatisticService;

public class LottoController {

    private final InputService inputService;
    private final LottoService lottoService;
    private final WinningStatisticService winningStatisticService;

    public LottoController(WinningStatisticService winningStatisticService,
        InputService inputService, LottoService lottoService) {
        this.inputService = inputService;
        this.lottoService = lottoService;
        this.winningStatisticService = winningStatisticService;
    }

    public void play() {
        Integer purchaseAmount = inputService.getPurchaseAmount();
        List<Lotto> lottos = lottoService.purchaseLottos(purchaseAmount);
        List<Integer> winningNumbers = inputService.getWinningNumbers();
        Integer bonusNumber = inputService.getBonusNumber();
        WinningLotto winningLotto = new WinningLotto(winningNumbers, bonusNumber);
        winningStatisticService.saveRankCount(lottos, winningLotto);
        winningStatisticService.showWinningStatistic(purchaseAmount);
    }
}
