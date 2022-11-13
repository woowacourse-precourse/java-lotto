package lotto.controller;

import lotto.input.InputBonusNumber;
import lotto.input.InputPurchaseAmount;
import lotto.input.InputWinningNumbers;
import lotto.model.*;
import lotto.service.LottoResultService;
import lotto.service.ProfitRateService;
import lotto.view.ProfitRateView;
import lotto.view.StatisticsView;
import lotto.view.TicketView;

import java.util.List;
import java.util.Map;

public class MainController {
    public static void run() {
        Ticket ticket = new Ticket(InputPurchaseAmount.input());
        TicketView.outPut(ticket);

        WinningLotto winningLotto = new WinningLotto(InputWinningNumbers.input(), InputBonusNumber.input());
        Map<Prize, Integer> statistics = LottoResultService.getStatistics(ticket, winningLotto);
        StatisticsView.outPut(statistics);

        double rate = ProfitRateService.calculateRate(ticket.getPurchaseAmount(), LottoResultService.getPrizeMoney(statistics));
        ProfitRate profitRate = new ProfitRate(rate);
        ProfitRateView.outPut(profitRate);
    }
}
