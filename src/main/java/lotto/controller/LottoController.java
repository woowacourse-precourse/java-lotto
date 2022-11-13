package lotto.controller;

import lotto.domain.model.LottoService;
import lotto.domain.model.Lottos;
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

        showLottos(InputView.inputLotteryPurchaseAmount());
        LottoRequest winningLottoRequest = InputView.inputLottoNumbers();
        LottoNumberRequest bonusNumberRequest = InputView.inputBonusNumber();

    }

    private void showLottos(MoneyRequest moneyRequest) {
        try {
            Lottos lottos = lottoService.getGeneratedLottoList(moneyRequest);
            OutputView.printLottos(lottos);
        } catch (IllegalArgumentException exception) {
            OutputView.printException(exception);
        }
    }
/*
    private void showStatistics(LottoRequest lottoRequest, LottoNumberRequest bonusNumberRequest) {

    }*/


}
