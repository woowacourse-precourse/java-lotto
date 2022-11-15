package lotto.controller;

import lotto.domain.LottoTicket;
import lotto.domain.Winning;
import lotto.domain.WinningNumber;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {
    public void run() {
        String inputMoney = InputView.inputMoney();
        LottoTicket lottoTicket = new LottoTicket(inputMoney);
        OutputView.buyLottoCount(lottoTicket.getTicketCount());
        OutputView.showLottoTicket(lottoTicket);

        String inputWinNumber = InputView.inputWinNumber();
        String inputBonusNumber = InputView.inputBonusNumber();
        WinningNumber winningNumber = new WinningNumber(inputWinNumber, inputBonusNumber);

        Winning winning = new Winning(lottoTicket, winningNumber);
        winning.checkWinningResult();
        OutputView.winStatistics(winning.getLottoResult());
        OutputView.showRating(winning.getTotalRate());
    }
}
