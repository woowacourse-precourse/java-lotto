package controller;

import lotto.*;
import view.Input;
import view.Output;

public class LottoController {
    public void implement() {
        LottoPurchase purchase = inputMoney();
        LottoTickets lottoTickets = changeTickets(purchase);
        WinningNumbers winningNumbers = createWinningNumbers();
        WinningResult winningResult = createWinningResult(lottoTickets,winningNumbers);

        printResult(purchase, winningResult);
    }

    private LottoPurchase inputMoney() {
        try {
            return new LottoPurchase(Input.inputMoney());
        } catch (IllegalArgumentException exception) {
            Output.outputException(exception);
            return inputMoney();
        }
    }

    private LottoTickets changeTickets(LottoPurchase money) {
        int count = money.calculateTicketCount();
        Output.outputTicketCount(count);

        LottoTickets lottoTickets = new LottoTickets(count);
        Output.outputTicket(lottoTickets);
        return lottoTickets;
    }

    private WinningNumbers createWinningNumbers() {
        try {
            return new WinningNumbers(Input.inputWinNumber(),Input.bonusNumber());
        } catch (IllegalArgumentException exception) {
            Output.outputException(exception);
            return createWinningNumbers();
        }
    }

    private WinningResult createWinningResult(LottoTickets lottos, WinningNumbers winningNumbers) {
        return lottos.getWinningStatistic(winningNumbers);
    }

    private void printResult(LottoPurchase purchase, WinningResult winningResult) {
        Output.outputWinningResult(winningResult);
        Output.printProfit(purchase.calculateProfit(winningResult.getAllPrize()));
    }
}
