package lotto.controller;

import java.util.List;
import lotto.service.ResultService;
import lotto.view.InputView;
import lotto.view.OutputView;

public class ResultController {
    private static ResultController instance;
    private static ResultService resultService;

    private ResultController() {
    }

    public static ResultController getInstance() {
        if (instance == null) {
            instance = new ResultController();
            resultService = ResultService.getInstance();
        }
        return instance;
    }

    public void enterWinningNumbers() {
        OutputView.printAskWinningNumbers();
        String input = InputView.input();
        List<String> winningNumbers = resultService.splitWinningNumbers(input);
        resultService.validate(winningNumbers);
        resultService.saveWinningNumbers(winningNumbers);
    }

    public void enterBonusNumber() {
        OutputView.printAskBonusNumber();
        String bonusNumber = InputView.input();
        resultService.validateNumber(bonusNumber);
        resultService.saveBonusNumber(bonusNumber);
    }

    public void printLottoResult() {
        resultService.getLottoResult();
    }
}
