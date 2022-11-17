package lotto.controller;

import lotto.domain.model.Lottos;
import lotto.domain.model.WinningLotto;
import lotto.domain.model.WinningStatistics;
import lotto.domain.model.request.LottoNumberRequest;
import lotto.domain.model.request.LottoRequest;
import lotto.domain.model.request.MoneyRequest;
import lotto.domain.service.LottoService;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {
    private final LottoService lottoService;

    public LottoController(LottoService lottoService) {
        this.lottoService = lottoService;
    }

    public void run() {
        try {
            MoneyRequest moneyRequest = InputView.inputLotteryPurchaseAmount();
            Lottos lottos = showLottos(moneyRequest);

            LottoRequest winningLottoRequest = InputView.inputLottoNumbers();
            LottoNumberRequest bonusNumberRequest = InputView.inputBonusNumber();
            WinningLotto winningLotto = new WinningLotto(winningLottoRequest, bonusNumberRequest);

            WinningStatistics winningStatistics = showStatistics(winningLotto, lottos);
            showYield(winningStatistics, moneyRequest);
        } catch (IllegalArgumentException exception) {
            OutputView.printException(exception);
        }
    }

    private void showYield(WinningStatistics winningStatistics, MoneyRequest moneyRequest) {
        Double yield = lottoService.getRateOfReturn(winningStatistics, moneyRequest);
        OutputView.printRateOfReturn(yield);
    }

    private Lottos showLottos(MoneyRequest moneyRequest) {

        Lottos lottos = lottoService.getGeneratedLottoList(moneyRequest);
        OutputView.printLottos(lottos);
        return lottos;
    }

    private WinningStatistics showStatistics(WinningLotto winningLotto, Lottos lottos) {
        WinningStatistics winningStatistics = lottoService.getWinningStatistics(winningLotto, lottos);
        OutputView.printStatistics(winningStatistics);
        return winningStatistics;
    }


}
