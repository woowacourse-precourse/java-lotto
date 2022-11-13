package lotto.controller;

import lotto.constants.message.ExceptionMessage;
import lotto.service.LottoService;
import lotto.validator.InputValidator;
import lotto.views.InputView;

public class LottoController {

    private final LottoService lottoService = new LottoService();
    private final InputValidator inputValidator = new InputValidator();
    private final InputView inputView = new InputView();

    public void startLottoApplication() {
        String inputPrice = inputView.inputPrice();
        if (!inputValidator.validateInputPrice(inputPrice)) {
            restartLottoApplication();
            return;
        }
        lottoService.buyLottos(Integer.parseInt(inputPrice));
    }

    private void restartLottoApplication() {
        inputView.printInputPriceAgain();
        startLottoApplication();
    }


}