package lotto.service;

import lotto.model.Player;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoService {
    private final InputView inputView;
    private final OutputView outputView;

    public LottoService() {
        inputView = new InputView();
        outputView = new OutputView();
    }

    public Player createPlayer() {
        outputView.printInputPurchaseAmount();
        Player player = new Player(inputView.inputPurchaseAmount());
        return player;
    }
}
