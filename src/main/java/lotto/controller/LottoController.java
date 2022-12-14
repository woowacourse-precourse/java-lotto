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

        } catch (IllegalArgumentException exception) {
            outputView.printMessage(exception.getMessage());
        }
    }

    private void requestBuyingLottos() {
        TotalLotto totalLotto = lottoService.buyLottos(InputValidator.validateInputPrice(inputView.inputPrice()));
        outputView.printBuyingLottos(totalLotto);
    }
}
