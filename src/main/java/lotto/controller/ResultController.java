package lotto.controller;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import lotto.domain.Lotto;
import lotto.domain.WinningResult;
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

    public void enterWinningNumbers() throws IllegalArgumentException {
        OutputView.printAskWinningNumbers();
        String input = InputView.input();
        List<String> winningNumbers = resultService.splitWinningNumbers(input);
        resultService.validateWinningNumbers(winningNumbers);
        resultService.saveWinningNumbers(winningNumbers);
    }

    public void enterBonusNumber() throws IllegalArgumentException {
        OutputView.printAskBonusNumber();
        String bonusNumber = InputView.input();
        resultService.validateBonusNumber(bonusNumber);
        resultService.saveBonusNumber(bonusNumber);
    }

    public void printLottoResult(List<Lotto> issuedLotteries) {
        resultService.saveLottoResult(issuedLotteries);
        List<WinningResult> winningResults = Arrays.asList(WinningResult.values());
        Collections.reverse(winningResults);
        Map<WinningResult, Integer> lottoResultCount = resultService.getLottoResultCount();

        OutputView.printLottoResultHeaderMessage();
        for (WinningResult winningResult : winningResults) {
            OutputView.printLottoResult(winningResult.toString(), lottoResultCount.getOrDefault(winningResult, 0));
        }
    }
}
