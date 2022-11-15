package lotto.controller;

import java.util.List;
import lotto.constants.enums.WinResultStatus;
import lotto.domain.WinningNumber;
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
        boolean isRestart;
        try {
            isRestart = inputValidator.validateInputPrice(inputPrice);
        } catch (IllegalArgumentException exception) {
            printLogInfo(exception);
            return;
        }
        determineNextMove(isRestart, Integer.parseInt(inputPrice));
    }

    private void determineNextMove(boolean isRestart, int inputPrice) {
        if (isRestart) {
            restartLottoApplication();
            return;
        }
        printBroughtLottoMessage(inputPrice);
    }

    private void restartLottoApplication() {
        inputView.printInputPriceAgain();
        startLottoApplication();
    }

    private void printBroughtLottoMessage(int inputPrice) {
        outputView.outputLottoBuyingResult(lottoService.buyLottos(inputPrice));
        requestWinningNumber();
    }

    private void requestWinningNumber() {
        try {
            printLottoResult(lottoService.createWinResults(new WinningNumber(inputView.inputWinningNumber())));
        } catch (IllegalArgumentException exception) {
            printLogInfo(exception);
        }
    }

    private void printLottoResult(List<WinResultStatus> winResults) {
        outputView.outputLottoResult(lottoService.createLottoResult(winResults));
    }

    private static void printLogInfo(IllegalArgumentException exception) {
        System.out.println(exception.getMessage());
    }

}