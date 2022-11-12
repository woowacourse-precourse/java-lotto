package lotto.controller;

import lotto.input.*;
import lotto.model.*;
import lotto.service.*;
import lotto.view.*;


import java.util.List;
import java.util.Map;

public class MainController {
    public static void run() {
        PurchaseAmount purchaseAmount = InputPurchaseAmount.input();
        Ticket ticket = new Ticket(purchaseAmount);
        TicketView.outPut(ticket);

        List<Integer> winningNumbers = InputWinningNumbers.input();
        BonusNumber bonusNumber = InputBonusNumber.input();
        WinningLotto winningLotto = new WinningLotto(winningNumbers, bonusNumber);
        Map<Prize, Integer> statistics = LottoResultService.getStatistics(ticket, winningLotto);
        StatisticsView.outPut(statistics);

        double prizeMoney = LottoResultService.getPrizeMoney(statistics);
        double rate = ProfitRateService.calculateRate(purchaseAmount, prizeMoney);
        ProfitRate profitRate = new ProfitRate(rate);
        ProfitRateView.outPut(profitRate);
    }
}
