package lotto.controller;

import camp.nextstep.edu.missionutils.Console;
import lotto.model.Lottos;
import lotto.model.Prize;
import lotto.model.Result;
import lotto.service.LottoService;
import lotto.utils.ValidationUtils;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.Map;

public class LottoController {

    private static LottoService lottoService = new LottoService();

    public static void run() {
        Lottos lottos = inputMoneyAmount();
        Result result = inputWinningNumber();

        Map<Prize, Long> winningResult = lottoService.calculateEarningRates(lottos, result);
        OutputView.printResultMessage(winningResult);
    }

    private static Lottos inputMoneyAmount() {
        InputView.printInputMoneyMessage();
        String input = Console.readLine();
        Lottos lottos = lottoService.purchaseLottos(input);
        OutputView.printLottosHistory(lottos);
        return lottos;
    }

    private static Result inputWinningNumber() {
        String winningNumbers = inputWinningNumbers();
        String bonusNumber = inputBonusNumber();
        return lottoService.saveResult(winningNumbers, bonusNumber);
    }

    private static String inputWinningNumbers() {
        InputView.printInputWinningNumbers();
        String winningNumbers = Console.readLine();
        ValidationUtils.validateWinningNumber(winningNumbers);
        return winningNumbers;
    }

    private static String inputBonusNumber() {
        InputView.printInputBonusNumber();
        String bonusNumber = Console.readLine();
        ValidationUtils.validateBonusNumber(bonusNumber);
        return bonusNumber;
    }
}
