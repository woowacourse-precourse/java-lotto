package lotto.controller;

import lotto.model.Prize;
import lotto.model.ProfitRate;
import lotto.model.Ticket;
import lotto.service.LottoResultService;
import lotto.service.ProfitRateService;
import lotto.view.ProfitRateView;

import java.util.Map;

public class ProfitRateController {
    public static void run(Ticket ticket, Map<Prize, Integer> statistics) {
        double prizeMoney = LottoResultService.getPrizeMoney(statistics);
        int purchaseAmount = ticket.getPurchaseAmount();

        double rate = ProfitRateService.calculateRate(purchaseAmount, prizeMoney);
        ProfitRate profitRate = new ProfitRate(rate);

        ProfitRateView.outPut(profitRate);
    }
}
