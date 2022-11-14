package lotto.controller;

import lotto.domain.Lotto;
import lotto.service.LottoService;
import java.util.List;

import static lotto.view.OutputView.*;
import static lotto.view.InputView.*;

public class LottoGame {
    static int purchaseAmount;
    static List<Integer> winningNumbers;
    static List<Lotto> lottos;

    public void run() {

    }

    public void purchaseLotto() {
        printLottoPurchaseInputNotice();
        purchaseAmount = readAmountOfLottoPrice();

        lottos = LottoService.generateLottoByPurchaseAmount(purchaseAmount);

        printLottoPurchaseResult(lottos);
    }

    public void enterWinningNumber() {
        printWinningNumberInputNotice();
        winningNumbers = readWinningNumbers();
    }
}
