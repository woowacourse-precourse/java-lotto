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
        String inputMoney = printInputMesssageAndInputAmount();
        Lottos lottos = purchaseLottosAndPrintHistory(inputMoney);
        Result result = inputWinningNumber();
        Map<Prize, Long> winningResults = compareResultAndPrintResult(lottos, result);
        calculateEarningRatesAndPrint(inputMoney, winningResults);
    }

    private static void calculateEarningRatesAndPrint(String inputMoney, Map<Prize, Long> winningResults) {
        Double earningRates = lottoService.calculateEarningRates(inputMoney, winningResults);
        OutputView.printEarningRates(earningRates);
    }

    private static Map<Prize, Long> compareResultAndPrintResult(Lottos lottos, Result result) {
        Map<Prize, Long> winningResult = lottoService.compareResult(lottos, result);
        OutputView.printResultMessage(winningResult);
        return winningResult;
    }

    private static Lottos purchaseLottosAndPrintHistory(String inputMoney) {
        Lottos lottos = lottoService.purchaseLottos(inputMoney);
        OutputView.printLottosHistory(lottos);
        return lottos;
    }

    private static String printInputMesssageAndInputAmount() {
        InputView.printInputMoneyMessage();
        String money = Console.readLine();
        ValidationUtils.validateNumber(money);
        return money;
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
