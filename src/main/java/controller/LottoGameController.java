package controller;

import domain.LottoGenerator;
import domain.LottoPurchaseAmount;
import domain.WinningTicket;
import lotto.LottoTickets;
import view.InputView;
import view.OutputView;

public class LottoGameController {
    private final LottoGenerator lottoTicketGenerator = new LottoGenerator();

    public void run() {
        LottoPurchaseAmount lottoPurchaseAmount = inputMoney();
        LottoTickets lottoTickets = purchaseLotto((int) lottoPurchaseAmount.calculateNumberOfLottoTickets());
        
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
}
