package lotto.controller;

import lotto.service.LottoGameService;

public class LottoGameController {

    private final LottoGameService lottoGameService;

    public LottoGameController() {
        this.lottoGameService = new LottoGameService();
    }

    public int inputMoney(final String money) {
        return lottoGameService.inputMoney(money);
    }

    public void printLottoTickets(int lottoTicketCount) {
    }
}
