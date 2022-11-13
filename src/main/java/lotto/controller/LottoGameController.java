package lotto.controller;

import java.util.List;
import lotto.Lotto;
import lotto.service.LottoGameService;

public class LottoGameController {

    private final LottoGameService lottoGameService;

    public LottoGameController() {
        this.lottoGameService = new LottoGameService();
    }

    public int buyLottoTickets(final String purchaseAmount) {
        return lottoGameService.buyLottoTickets(purchaseAmount);
    }

    public void printLottoTickets(final int lottoTicketCount) {
        for (int i = 0; i < lottoTicketCount; i++) {
            Lotto lotto = Lotto.issueLottoTicket();
            System.out.println(lotto.getNumbers());
        }
    }

    public Lotto pickWinningNumbers(final String winningNumbers) {
        return lottoGameService.pickWinningNumbers(winningNumbers);
    }
}
