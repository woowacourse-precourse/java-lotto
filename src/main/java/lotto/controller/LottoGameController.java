package lotto.controller;

import lotto.model.Money;

import lotto.model.exception.InputException;

import lotto.model.lottoticket.Lotto;
import lotto.model.lottoticket.LottoNumber;
import lotto.model.lottoticket.LottoTickets;
import lotto.model.lottoticket.LottoWinningNumber;

import lotto.model.lottogenerator.LottoGenerator;

import lotto.model.lottostatistics.WinningCalculator;
import lotto.model.lottostatistics.WinningStatistics;

import lotto.view.InputView;
import lotto.view.Messages;
import lotto.view.OutputView;

public class LottoGameController {

    private final InputView inputView;
    private final OutputView outputView;

    public LottoGameController() {
        this.inputView = new InputView();
        this.outputView = new OutputView();
    }

    public void run() {
        try {
            Money budget = scanBudget();

            LottoTickets lottoTickets = createLottoTicketsBy(budget);
            outputView.printLottoTicketsAmount(Messages.PURCHASED_TICKET_COUNTS, lottoTickets);

            LottoWinningNumber lottoWinningNumber = createLottoWinningNumber();
            WinningStatistics winningStatistics =
                    getWinningStatistics(lottoWinningNumber, lottoTickets);
            outputView.printOutputResult(winningStatistics, budget);
        } catch (InputException errorMessage) {
            outputView.printExceptionMessage(errorMessage);
        }
    }

    public Money scanBudget() {
        String budget = inputView.scanWith(Messages.REQUEST_BUDGET_INPUT);

        return new Money(budget);
    }

    public LottoTickets createLottoTicketsBy(Money budget) {
        long NumberOfTickets = budget.getNumberOfTickets();
        LottoGenerator lottoGenerator = new LottoGenerator();

        return lottoGenerator.generateAutoLottoTicketsAs(NumberOfTickets);
    }

    public LottoWinningNumber createLottoWinningNumber() {
        Lotto winningNumbers = scanWinningNumbers();
        LottoNumber bonusNumber = scanBonusNumber();

        return new LottoWinningNumber(winningNumbers, bonusNumber);
    }

    public Lotto scanWinningNumbers() {
        String winningNumber = inputView.scanWith(Messages.REQUEST_WINNING_NUMBERS_INPUT);

        return new Lotto(winningNumber);
    }

    public LottoNumber scanBonusNumber() {
        String bonusNumber = inputView.scanWith(Messages.REQUEST_BONUS_NUMBER_INPUT);

        return new LottoNumber(bonusNumber);
    }

    public WinningStatistics getWinningStatistics(LottoWinningNumber lottoWinningNumber,
            LottoTickets lottoTickets) {
        WinningCalculator winningCalculator = new WinningCalculator();

        return winningCalculator.calculateStatistics(lottoWinningNumber, lottoTickets);
    }
}
