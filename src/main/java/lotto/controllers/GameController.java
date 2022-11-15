package lotto.controllers;

import lotto.applications.GameService;
import lotto.view.Input;
import lotto.view.Output;

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
        final int numberOfLotto = gameService.getNumberOfLotto(money);
        opening(numberOfLotto);
    }

    private void opening(int numberOfLotto) {
        Output.printNumberOfPurChase(numberOfLotto);
    }
}
