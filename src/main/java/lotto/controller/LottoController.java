package lotto.controller;

import lotto.domain.LottoTicket;
import lotto.domain.Winning;
import lotto.domain.WinningNumber;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {
    private LottoTicket lottoTicket;
    private WinningNumber winningNumber;
    private Winning winning;

    public void run() {
        String inputMoney = InputView.inputMoney();
        makeLottoTicket(inputMoney);

        String inputWinNumber = InputView.inputWinNumber();
        String inputBonusNumber = InputView.inputBonusNumber();
        winningNumber = new WinningNumber(inputWinNumber, inputBonusNumber);

        showStatistics(lottoTicket, winningNumber);
    }

    public void makeLottoTicket(String inputMoney) {
        lottoTicket = new LottoTicket(inputMoney);
        OutputView.buyLottoCount(lottoTicket.getTicketCount());
        OutputView.showLottoTicket(lottoTicket);
    }

    public void showStatistics(LottoTicket lottoTicket, WinningNumber winningNumber) {
        winning = new Winning(lottoTicket, winningNumber);
        winning.checkWinningResult();
        OutputView.winStatistics(winning.getLottoResult());
        OutputView.showRating(winning.getTotalRate());
    }
}
