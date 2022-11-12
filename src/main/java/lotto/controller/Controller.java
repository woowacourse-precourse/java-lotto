package lotto.controller;

import lotto.domain.Buyer;
import lotto.service.LottoService;
import lotto.view.View;

public class Controller {
    private final Buyer buyer;
    private final LottoService lottoService;

    private final View view;

    public Controller() {
        this.buyer = new Buyer();
        this.lottoService = new LottoService();
        this.view = new View();
    }

    public void startGame() {
        view.printWelcomeMessage();
        String input = buyer.inputMoney();
        lottoService.getLottosByMoney(buyer, input);
        view.printLottoCountMessage(buyer.getLottoCount());
        view.printLottosInfoByBuyer(buyer.getLottos());
    }
}
