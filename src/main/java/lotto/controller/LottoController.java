package lotto.controller;

import lotto.domain.RateOfReturn;
import lotto.domain.Ticket;
import lotto.domain.Win;
import lotto.dto.BonusNumberDto;
import lotto.dto.MoneyDto;
import lotto.dto.WinningNumbersDto;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.List;

public class LottoController {

    public void start() {
        try {
            process();
        } catch (IllegalArgumentException exception) {
            OutputView.printExceptionMessage(exception);
        } catch (Exception exception) {
            OutputView.printExceptionMessage(exception);
        }
    }

    public void process() {
        WinningNumbersDto winningNumbersDto;
        BonusNumberDto bonusNumberDto;
        Win win;
        int money = getInputMoney();
        Ticket tickets = Ticket.purchase(money);

        printPurchaseLotto(tickets);

        winningNumbersDto = InputView.inputWinningNumbers();
        bonusNumberDto = InputView.inputBonusNumber(winningNumbersDto);
        win = calculateWinnings(tickets, winningNumbersDto, bonusNumberDto);

        printWinnings(win);
        printRateOfReturn(money, win);
    }

    private void printRateOfReturn(int money, Win win) {
        double rate = getRateOfReturn(money, win);
        OutputView.printRateOfReturn(rate);
    }

    private double getRateOfReturn(int money, Win win) {
        double winnings = win.getWinnings();
        RateOfReturn rateOfReturn = new RateOfReturn(winnings, money);
        return rateOfReturn.calculate();
    }

    private void printWinnings(Win win) {
        List<Integer> winningsCount = win.getWinningsCount();
        OutputView.printWinnings(winningsCount);
    }

    private Win calculateWinnings(Ticket tickets, WinningNumbersDto winningNumbersDto, BonusNumberDto bonusNumberDto) {
        Win win = new Win();
        win.compareAllLotto(tickets, winningNumbersDto.getWinningNumbers(), bonusNumberDto.getBonusNumber());
        return win;
    }

    private void printPurchaseLotto(Ticket tickets) {
        int count = tickets.size();
        String lottoNumbers = tickets.getPurchaseMessage();

        OutputView.printPurchaseLottoMessage(count, lottoNumbers);
    }

    private int getInputMoney() {
        MoneyDto moneyDto = InputView.inputMoney();
        return moneyDto.getMoney();
    }
}
