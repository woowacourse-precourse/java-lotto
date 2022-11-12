package lotto.controller;

import lotto.service.GameService;
import lotto.view.InputView;
import lotto.view.OutputView;

public class GameController {
    private GameService gameService;

    public GameController(GameService gameService) {
        this.gameService = gameService;
    }

    public void play() {
        try {
            createMoney();
            generateLottosByMoney();
        } catch (Exception e) {
            OutputView.announceError(e.getMessage());
        }

    }

    private void createMoney() {
        OutputView.announcePayNotice();

        gameService.createMoney(InputView.getUserInput());
    }

    private void generateLottosByMoney() {
        OutputView.announceLottos(gameService.generateLottosByMoney());
    }


}
