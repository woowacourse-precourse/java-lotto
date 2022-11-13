package lotto.controller;

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

    }
}
