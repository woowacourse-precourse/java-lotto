package lotto.controller;

import lotto.service.LottoService;
import lotto.validator.InputValidator;
import lotto.views.InputView;
import lotto.views.OutputView;

public class LottoController {

    private final LottoService lottoService = new LottoService();
    private final InputValidator inputValidator = new InputValidator();
    private final InputView inputView = new InputView();
    private final OutputView outputView = new OutputView();

    public void startLottoApplication() {
        String inputPrice = inputView.inputPrice();
        if (!inputValidator.validateInputPrice(inputPrice)) {
            restartLottoApplication();
            return;
        }
        printBroughtLottoMessage(Integer.parseInt(inputPrice));
    }

    private void printBroughtLottoMessage(int inputPrice) {
        outputView.outputLottoBuyingResult(lottoService.buyLottos(inputPrice));
    }

    private void restartLottoApplication() {
        inputView.printInputPriceAgain();
        startLottoApplication();
    }


}