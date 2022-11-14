package controller;

import domain.*;
import lotto.LottoTickets;
import view.InputView;
import view.OutputView;

import java.util.List;
import java.util.Map;

public class LottoGameController {
    private final LottoGenerator lottoTicketGenerator = new LottoGenerator();

    public void run() {
        LottoPurchaseAmount lottoPurchaseAmount = inputMoney();
        LottoTickets lottoTickets = purchaseLotto(lottoPurchaseAmount.calculateNumberOfLottoTickets());
        WinningTicket winningTicket = getWinningTicket();
        LottoResult lottoResult = getLottoResult(lottoTickets, winningTicket);
        printResult(lottoResult.getLottoResult());
    }

    private LottoPurchaseAmount inputMoney() {
        return new LottoPurchaseAmount(InputView.inputMoney());
    }

    private LottoTickets purchaseLotto(int count) {
        LottoTickets lottoTickets = lottoTicketGenerator.generateLottoTickets(count);
        OutputView.printTicketPurchasedMessage(count);
        OutputView.printGeneratedLottoTickets(lottoTickets);

        return lottoTickets;
    }

    private WinningTicket getWinningTicket() {
        List<Integer> winningTicket = InputView.inputWinningNumbers();
        int bonusNumber = InputView.inputBonusNumber();
        return lottoTicketGenerator.generateWinningTicket(winningTicket, bonusNumber);
    }

    private LottoResult getLottoResult(LottoTickets lottoTickets, WinningTicket winningTicket) {
        return new LottoResult(lottoTickets.getResult(winningTicket));
    }

    private void printResult(Map<Ranking, Integer> winningResult) {
        OutputView.printWinningStatistics(winningResult);
    }
}
