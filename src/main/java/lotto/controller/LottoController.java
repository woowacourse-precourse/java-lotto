package lotto.controller;

import lotto.domain.model.LottoService;
import lotto.domain.model.Lottos;
import lotto.domain.model.WinningLotto;
import lotto.domain.model.request.LottoNumberRequest;
import lotto.domain.model.request.LottoRequest;
import lotto.domain.model.request.MoneyRequest;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {
    private final LottoService lottoService;

    public LottoController(LottoService lottoService) {
        this.lottoService = lottoService;
    }

    public void run() {
        try {
            Lottos lottos = showLottos(InputView.inputLotteryPurchaseAmount());

            LottoRequest winningLottoRequest = InputView.inputLottoNumbers();
            LottoNumberRequest bonusNumberRequest = InputView.inputBonusNumber();
            WinningLotto winningLotto = new WinningLotto(winningLottoRequest, bonusNumberRequest);
            
        } catch (IllegalArgumentException exception) {
            OutputView.printException(exception);
        }

    }

    private Lottos showLottos(MoneyRequest moneyRequest) {

        Lottos lottos = lottoService.getGeneratedLottoList(moneyRequest);
        OutputView.printLottos(lottos);
        return lottos;
    }

}
