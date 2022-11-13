package lotto.controller;

import lotto.service.LottoService;
import lotto.view.InputView;
import lotto.view.OutputView;

public class Controller {
    private final InputView inputView;
    private final OutputView outputView;
    private final LottoService lottoService;

    public Controller() {
        inputView = new InputView();
        outputView = new OutputView();
        lottoService = new LottoService();
    }

    public void play() {
        Long purchaserId = -1L;
        int money = 0;

        try {
            money = inputView.inputMoney();
            purchaserId = lottoService.generatePurchaser(money);
        } catch (IllegalArgumentException e) {
            outputView.printException(e.getMessage());
            return;
        }
    }

}
