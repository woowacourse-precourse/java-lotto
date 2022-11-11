package lotto.controller;

import lotto.input.InputBonusNumber;
import lotto.input.InputPurchaseAmount;
import lotto.input.InputWinningNumbers;
import lotto.model.*;
import lotto.view.LottoResultView;
import lotto.view.ProfitRateView;
import lotto.view.TicketView;

import java.util.List;

public class MainController {
    public static void run() {
        PurchaseAmount purchaseAmount = InputPurchaseAmount.input();

        Ticket ticket = new Ticket(purchaseAmount);
        TicketView.outPut(ticket);

        List<Integer> winningNumbers = InputWinningNumbers.input();
        BonusNumber bonusNumber = InputBonusNumber.input();
        WinningLotto winningLotto = new WinningLotto(winningNumbers, bonusNumber);

        LottoResult lottoResult = new LottoResult(ticket, winningLotto);
        LottoResultView.outPut(lottoResult);

        ProfitRate profitRate = new ProfitRate(purchaseAmount, lottoResult);
        ProfitRateView.outPut(profitRate);
    }
}
