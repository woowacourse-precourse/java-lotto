package lotto.controller;

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

    public void printLottoTickets(int lottoTicketCount) {
        for (int i = 0; i < lottoTicketCount; i++) {
            Lotto lotto = Lotto.issueLottoTicket();
            System.out.println(lotto.getNumbers());
        }
    }
}
