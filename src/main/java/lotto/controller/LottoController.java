package lotto.controller;

import lotto.model.numbers.Bonus;
import lotto.model.numbers.Lotto;
import lotto.model.numbers.LottoDraw;
import lotto.model.numbers.LottoStore;
import lotto.model.numbers.PlayerNumbers;
import lotto.model.result.WinningStatistics;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {
    private final InputView inputView;
    private final OutputView outputView;

    public LottoController(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void play() {
        try {
            PlayerNumbers playerNumbers = buyLotto();
            LottoDraw lottoDraw = drawLottoNumbers();
            createResult(playerNumbers, lottoDraw);
        } catch (IllegalArgumentException exception) {
            outputView.printExceptionMessage(exception);
        }
    }

    private void createResult(PlayerNumbers playerNumbers, LottoDraw lottoDraw) {
        WinningStatistics statistics = WinningStatistics.from(lottoDraw, playerNumbers);
        outputView.printWinningStatistics(statistics);
    }

    private LottoDraw drawLottoNumbers() {
        Lotto winningNumbers = new Lotto(inputView.readWinningNumbers());
        Bonus bonusNumber = new Bonus(inputView.readBonusNumber());
        LottoDraw lottoDraw = LottoDraw.by(winningNumbers, bonusNumber);
        return lottoDraw;
    }

    private PlayerNumbers buyLotto() {
        int ticketNumber = LottoStore.buyTicketsByBudget(inputView.readBudget()).getTicketNumber();
        outputView.printTicketNumber(ticketNumber);
        PlayerNumbers playerNumbers = PlayerNumbers.issueLottoByTickets(ticketNumber);
        outputView.printPlayerNumbers(playerNumbers);
        return playerNumbers;
    }

}
