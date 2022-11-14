package lotto.controller;

import lotto.model.Result;
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
            createWinningManager();
            calculateResult();
        } catch (IllegalArgumentException e) {
            OutputView.announceError(e.getMessage());
            return;
        }
    }

    private void createMoney() {
        OutputView.announcePayNotice();

        gameService.createMoney(InputView.getUserInput());
    }

    private void generateLottosByMoney() {
        OutputView.announceLottos(gameService.generateLottosByMoney());
    }

    private void createWinningManager() {
        createWinningLotto();
        createBonusBall();
    }

    private void createWinningLotto() {
        OutputView.announceWinningLottoInputNotice();
        gameService.createWinningManager(InputView.getUserInput());
    }

    private void createBonusBall() {
        OutputView.announceBonusBallInputNotice();
        gameService.createBonusBall(InputView.getUserInput());
    }

    private void calculateResult() {
        Result result = gameService.calculateResult();
        String profitRate = gameService.calculateProfitRate();

        OutputView.announceResult(result, profitRate);
    }


}
