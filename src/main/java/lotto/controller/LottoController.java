package lotto.controller;

import lotto.constants.LottoConstants;
import lotto.domain.Lotto;
import lotto.domain.LottoEvaluator;
import lotto.domain.LottoShop;
import lotto.domain.Ranker;
import lotto.domain.Ticket;
import lotto.domain.WinningResult;
import lotto.ui.ErrorUI;
import lotto.ui.LottosPrintUI;
import lotto.ui.PurchaseUI;
import lotto.ui.RateOfReturnUI;
import lotto.ui.ResultPrintUI;
import lotto.ui.WinningNumberInputUI;

import java.util.List;
import java.util.Map;

public class LottoController {
    public void run() {
        try {
            Ticket ticket = purchase();
            List<Lotto> lottos = exchange(ticket);
            printPurchaseLotto(lottos);
            Ranker ranker = inputNumber();
            Map<WinningResult, Integer> result = ranker.rankTotal(lottos);
            printResult(result);
            printRateOfReturn(result, ticket);
        } catch (IllegalArgumentException e) {
            ErrorUI ui = new ErrorUI();
            ui.printError(e.getMessage());
        }
    }
    private Ticket purchase() {
        PurchaseUI ui = new PurchaseUI();
        return ui.purchase();
    }

    private List<Lotto> exchange(Ticket ticket) {
        LottoShop shop = new LottoShop();
        return shop.purchase(ticket);
    }

    private void printPurchaseLotto(List<Lotto> lottos) {
        LottosPrintUI ui = new LottosPrintUI();
        ui.print(lottos);
    }

    private Ranker inputNumber() {
        WinningNumberInputUI ui = new WinningNumberInputUI();
        return ui.setWinningNumber();
    }

    private void printResult(Map<WinningResult, Integer> result) {
        ResultPrintUI resultPrintUI = new ResultPrintUI();
        resultPrintUI.print(result);
    }

    private void printRateOfReturn(Map<WinningResult, Integer> result, Ticket ticket) {
        LottoEvaluator evaluator = new LottoEvaluator();
        RateOfReturnUI ui = new RateOfReturnUI();

        double currentValue = evaluator.evaluate(result);
        double initialValue = ticket.getCount() * LottoConstants.TICKET_PRICE;
        ui.print(currentValue, initialValue);
    }
}
