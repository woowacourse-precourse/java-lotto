package lotto.controllers;

import lotto.applications.GameService;
import lotto.view.Input;

public class GameController {
    private static GameController INSTANCE;
    private final GameService gameService;
    private GameController(GameService gameService) {
        this.gameService = gameService;
    }

    public static GameController getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new GameController(GameService.getInstance());
        }
        return INSTANCE;
    }

    public void startGame() {
        final int money = Input.inputPurchaseLottoValue();
    }
}
