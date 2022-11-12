package lotto.controller;

import lotto.model.Prize;
import lotto.model.Ticket;

import java.util.Map;

public class MainController {
    public static void run() {
        Ticket ticket = PurchaseController.run();
        Map<Prize, Integer> statistics = StatisticsController.run(ticket);
        ProfitRateController.run(ticket, statistics);
    }
}
