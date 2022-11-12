package lotto;

import lotto.domain.LottoService;
import lotto.ui.Ui;

public class Game {
    private final Ui ui;
    private final LottoService service;

    public Game(Ui ui, LottoService service) {
        this.ui = ui;
        this.service = service;
    }

    public void start() throws IllegalArgumentException {
        String balance = ui.inputBalance();
        int lottoAmount = service.getLottoAmount(balance);
    }
}
