package lotto.controllers;

import lotto.view.Input;

public class GameController {
    private static GameController INSTANCE;
    private GameController() {}

    public static GameController getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new GameController();
        }
        return INSTANCE;
    }

    public void startGame() {
        final int money = Input.inputPurchaseLottoValue();
    }
}
