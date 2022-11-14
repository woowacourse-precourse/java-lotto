package lotto.controller;

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
        String winningNumbers = InputView.input();
        resultService.validate(winningNumbers);

    }

    public void enterBonusNumber() {
        OutputView.printAskBonusNumber();
        String bonusNumber = InputView.input();
        resultService.validateNumber(bonusNumber);
    }
}
