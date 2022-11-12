package lotto.controller;

import lotto.domain.Buyer;
import lotto.domain.Lotto;
import lotto.domain.Money;
import lotto.service.LottoService;
import lotto.view.View;

import java.util.List;

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
    }
}
