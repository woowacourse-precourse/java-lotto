package lotto.controller;

import lotto.domain.*;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {
    public void start() {
        LottoAmount amount = inputAmount();
        LottoTicket lottoTicket = buyTickets(amount);
        WinningNumber winningNumber = inputWinningNumber();
        WinningResult winningResult = getWinningResult(lottoTicket, winningNumber);
        printResult(amount, winningResult);
    }

    private WinningNumber inputWinningNumber() {
        Lotto lotto = InputView.inputWinningNumber();
        int bonus = InputView.inputBonusNumber();
        return new WinningNumber(lotto, bonus);
    }

    private LottoAmount inputAmount() {
        return new LottoAmount(InputView.inputAmount());
    }

    private LottoTicket buyTickets(LottoAmount amount) {
        int ticketCount = amount.calculateLottoCount();
        OutputView.printTicketCount(ticketCount);

        LottoTicket lottoTicket = new LottoTicket(ticketCount);
        OutputView.printTicket(lottoTicket);
        return lottoTicket;
    }

    private WinningResult getWinningResult(LottoTicket lottoTicket, WinningNumber winningNumbers) {
        return lottoTicket.calculateWinningStatistic(winningNumbers);
    }

    private void printResult(LottoAmount money, WinningResult winningResult) {
        OutputView.printWinningStatistic(winningResult);
        OutputView.printProfit(money.calculateProfit(winningResult.calculatePrizeSum()));
    }

}
