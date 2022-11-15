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

    public static Map<Result, Integer> getResultPoints(List<Lotto> lottoNumber, Lotto winningNumber, int bonusNumber) {
        return LottoService.getWinningPoint(lottoNumber, winningNumber, bonusNumber);
    }

    public static int gameStartAndGetInput() {
        LottoView.printStartMessage();
        String input = LottoView.readLine();
        return LottoService.amountInputToInteger(input);
    }

    public static void printLottoPurchaseAmount(int amount, List<Lotto> lottoNumbers) {
        LottoView.printLottoPurchaseResult(amount, lottoNumbers);
    }

    public static int getLottoPurchaseCount(int amount) {
        return LottoService.getLottoPurchaseCount(amount);
    }

    public static List<Lotto> getLottoNumbers(int purchaseAmount) {
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
