package lotto.controller;

import lotto.service.GameService;
import lotto.domain.GameScore;
import lotto.view.GamePrint;

public class GameController {

    private final GameService gameService;

    public GameController() {
        this.gameService = new GameService();
    }

    public void start() {
        GameScore gameScore = gameService.lottoGameStart();
        GamePrint.printWinLottoStats(gameScore);
    }
}
