package lotto.controller;

import camp.nextstep.edu.missionutils.Console;
import lotto.model.Lottos;
import lotto.model.Result;
import lotto.service.LottoService;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {

    private static LottoService lottoService = new LottoService();

    public static void run() {
        inputMoneyAmount();
        Result result = inputWinningNumber();
    }

    private static void inputMoneyAmount() {
        InputView.printInputMoneyMessage();
        String input = Console.readLine();
        Lottos lottos = lottoService.purchaseLottos(input);
        OutputView.printLottosHistory(lottos);
    }

    private static Result inputWinningNumber() {
        String winningNumbers = inputWinningNumbers();
        String bonusNumber = inputBonusNumber();
        return lottoService.saveResult(winningNumbers, bonusNumber);
    }

    private static String inputWinningNumbers() {
        InputView.printInputWinningNumbers();
        return Console.readLine();
    }

    private static String inputBonusNumber() {
        InputView.printInputBonusNumber();
        return Console.readLine();
    }
}
