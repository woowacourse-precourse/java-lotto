package lotto.controller;

import lotto.model.*;
import lotto.view.Input;
import lotto.view.Output;

public class LottoController {
    public void play() {
        try {
            Purchase purchase = new Purchase(Input.PURCHASE_MONEY.getInput());
            LottoTicketing lottoTicketing = new LottoTicketing(purchase.getLottoTickets());
            Output.lottoTicketsOut(purchase.getLottoTickets(), lottoTicketing.getLottoTickets());
            WinningNumbers winningNumbers = new WinningNumbers(
                    Input.WINNING_NUMBERS.getInput(), Input.BONUS_NUMBER.getInput());
            Ranking ranking = new Ranking(lottoTicketing.getLottoTickets(), winningNumbers);
            ProfitRate profitRate = new ProfitRate(ranking.getRanking(), purchase.getPurchaseMoney());
            Output.printResult(ranking.getRanking(), profitRate.getProfitRate());
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
}
