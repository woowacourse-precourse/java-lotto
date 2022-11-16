package lotto.controller;

import lotto.domain.Buyer;
import lotto.domain.Rank;
import lotto.service.LottoService;
import lotto.view.View;

public class Controller {
    private final LottoService lottoService;
    private final Buyer buyer;
    private final View view;
    private final Rank rank;

    public Controller(LottoService lottoService, Buyer buyer, View view, Rank rank) {
        this.lottoService = lottoService;
        this.buyer = buyer;
        this.view = view;
        this.rank = rank;
    }

    public void startGame() {
        try {
            view.printWelcomeMessage();
            lottoService.getLottosByMoney(buyer);
            view.printLottoCountMessage(buyer.getLottoCount());
            view.printLottosInfoByBuyer(buyer.getLottos());
            lottoService.publishWinningNumbersWithBonusNumber(view);
            view.printWinningStatics();
            lottoService.getWinningStatics(buyer, rank);
            view.printWinningCount(rank);
            view.printRateOfReturn(buyer, rank);
        } catch(IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
}
