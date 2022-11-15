package lotto.controllers;

import lotto.applications.GameService;
import lotto.domains.Lotto;
import lotto.view.Input;
import lotto.view.Output;

import java.util.List;

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

        final List<Lotto> userBoughtLotteries = gameService.createLotteries(numberOfLotto);
    }

    private void opening(int numberOfLotto) {
        Output.printNumberOfPurChase(numberOfLotto);
    }
}
