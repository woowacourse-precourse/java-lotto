package lotto.controller;

import java.util.List;
import java.util.Map;
import lotto.domain.Lotto;
import lotto.domain.Result;
import lotto.service.LottoService;
import lotto.view.LottoView;

public class LottoController {

    private LottoController() {
    }

    public static void runGame() {
        long amount = gameStartAndGetInput();
        long purchaseCount = getLottoPurchaseCount(amount);
        List<Lotto> lottoNumbers = getLottoNumbers(purchaseCount);
        printLottoPurchaseAmount(purchaseCount, lottoNumbers);

        Lotto winningNumber = getWinningNumber();
        int bonusNumber = getBonusNumber();

        Map<Result, Integer> resultPoints = getResultPoints(lottoNumbers, winningNumber, bonusNumber);
        LottoView.printResultStatistics(resultPoints, LottoService.getTotalRate(resultPoints, amount));
    }

    public static Map<Result, Integer> getResultPoints(List<Lotto> lottoNumber, Lotto winningNumber, int bonusNumber) {
        return LottoService.getWinningPoint(lottoNumber, winningNumber, bonusNumber);
    }

    public static double getTotalRate(Map<Result, Integer> resultPoints, long amount) {
        return LottoService.getTotalRate(resultPoints, amount);
    }

    public static long gameStartAndGetInput() {
        LottoView.printStartMessage();
        String input = LottoView.readLine();
        return LottoService.amountInputToInteger(input);
    }

    public static void printLottoPurchaseAmount(long amount, List<Lotto> lottoNumbers) {
        LottoView.printLottoPurchaseResult(amount, lottoNumbers);
    }

    public static long getLottoPurchaseCount(long amount) {
        return LottoService.getLottoPurchaseCount(amount);
    }

    public static List<Lotto> getLottoNumbers(long purchaseAmount) {
        return LottoService.getLottoNumbers(purchaseAmount);
    }

    public static Lotto getWinningNumber() {
        LottoView.printInputLottoWinningMessage();
        return LottoService.getWinningNumber(LottoView.readLine());
    }

    public static int getBonusNumber() {
        LottoView.printInputBonusNumberMessage();
        return LottoService.getBonusNumber(LottoView.readLine());
    }
}
