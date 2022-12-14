package lotto.controller;

import lotto.domain.TotalLotto;
import lotto.service.LottoService;
import lotto.util.InputValidator;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {
    private final InputView inputView = new InputView();
    private final OutputView outputView = new OutputView();
    private final LottoService lottoService = new LottoService();

    public void run() {
        try {
            requestBuyingLottos();
            requestWinningNumber();
        } catch (IllegalArgumentException exception) {
            outputView.printMessage(exception.getMessage());
        }
    }

    private void requestWinningNumber() {
        lottoService.saveWinningNumber(InputValidator.validateWinningNumber(inputView.inputWinningNumber()));
    }

    private void requestBuyingLottos() {
        TotalLotto totalLotto = lottoService.buyLottos(InputValidator.validateBuyingPrice(inputView.inputPrice()));
        outputView.printBuyingLottos(totalLotto);
    }
}
