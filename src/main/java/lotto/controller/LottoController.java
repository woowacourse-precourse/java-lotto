package lotto.controller;

import camp.nextstep.edu.missionutils.Console;

import lotto.view.LottoMessage;
import lotto.service.LottoService;
import lotto.domain.Lotto;
import lotto.domain.LottoMoney;
import lotto.domain.WinningResult;

import java.util.List;

public class LottoController {
    private final LottoService lottoService = new LottoService();
    private final LottoMessage lottoMessage = new LottoMessage();

    public void run() {
        try {
            purchase();
            showPurchaseLotteries();
            inputWinningNumber();
            showWinningResult();
            showWinningProfitPercentage();
        } catch (IllegalArgumentException ex) {
            lottoMessage.printErrorMessage(ex.getMessage());
        }
    }

    private void purchase() {
        lottoMessage.printPurchaseMessage();
        lottoService.purchase(Console.readLine());
    }

    private void showPurchaseLotteries() {
        List<Lotto> purchaseLotteries = lottoService.getPurchaseLotteries();
        lottoMessage.printPurchasedLotteries(purchaseLotteries);
    }

    private void inputWinningNumber() {
        lottoMessage.printInputWinningNumber();
        String winningNumber = Console.readLine();
        lottoMessage.printInputBonusNumber();
        String bonusNumber = Console.readLine();

        lottoService.setWinningNumber(winningNumber, bonusNumber);
    }

    private void showWinningResult() {
        WinningResult winningResult = lottoService.calculateResult();
        lottoMessage.printWinningResult(winningResult);
    }

    private void showWinningProfitPercentage() {
        double profitPercentage = lottoService.calculateProfitPercentage();
        lottoMessage.printProfitPercentage(profitPercentage);
    }
}
