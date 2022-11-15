package lotto.controller;

import lotto.domain.*;
import lotto.view.InputView;

import java.util.List;

public class LottoGameController {
    private final LottoGenerator lottoTicketGenerator = new LottoGenerator();

    public void run() {
        LottoPurchaseAmount lottoPurchaseAmount = inputMoney();
        LottoTickets lottoTickets = purchaseLotto(lottoPurchaseAmount.calculateNumberOfLottoTickets());
        WinningTicket winningTicket = getWinningTicket();
        LottoResult lottoResult = getLottoResult(lottoTickets, winningTicket);
        SystemMessage.printResult(lottoResult.getRanks());
        SystemMessage.printProfit(lottoResult.calculateProfit(lottoPurchaseAmount.calculateNumberOfLottoTickets()));
    }

    private LottoPurchaseAmount inputMoney() {
        SystemMessage.inputMoney();
        return new LottoPurchaseAmount(InputView.inputNumber());
    }

    private LottoTickets purchaseLotto(int count) {
        LottoTickets lottoTickets = lottoTicketGenerator.generateLottoTickets(count);
        SystemMessage.printLottoTickets(count, lottoTickets);
        return lottoTickets;
    }

    private WinningTicket getWinningTicket() {
        SystemMessage.printWinningNumbers();
        List<Integer> winningTicket = InputView.inputWinningNumbers();
        SystemMessage.printBonusNumber();
        int bonusNumber = InputView.inputNumber();
        return lottoTicketGenerator.generateWinningTicket(winningTicket, bonusNumber);
    }

    private LottoResult getLottoResult(LottoTickets lottoTickets, WinningTicket winningTicket) {
        return new LottoResult(lottoTickets.getResult(winningTicket));
    }
}
