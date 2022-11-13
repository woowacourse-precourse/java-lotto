package lotto.controller;

import lotto.service.LottoService;
import lotto.service.PurchaserService;
import lotto.view.InputView;
import lotto.view.OutputView;

public class Controller {
    private final InputView inputView;
    private final OutputView outputView;

    public Controller() {
        inputView = new InputView();
        outputView = new OutputView();
    }

    public void play() {
        int money = inputPurchaserMoney();
    }

    private int inputPurchaserMoney() {
        try {
            return inputView.inputMoney();
        } catch (IllegalArgumentException e) {
            outputView.printException(e.getMessage());
        }
    }
}
