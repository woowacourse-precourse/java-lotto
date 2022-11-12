package lotto.controller;

import lotto.model.GameDTO;

public class ProcessingGameData {
    private GameDTO gameDTO;

    public ProcessingGameData(GameDTO gameDTO) {
        this.gameDTO = gameDTO;
        makeAllAmount(gameDTO);
        makeRatio(gameDTO);
    }
    private void makeRatio(GameDTO gameDTO) {
        double result = 0;
        double allAmount = gameDTO.getWinningAmount();
        double allcost = gameDTO.getPurchaseAmount();
        result = (allAmount / allcost) * 100;
        gameDTO.setReturnOfRate(Math.round(result * 10) / 10.0);
    }

    private void makeAllAmount(GameDTO gameDTO) {
        int result = 0;
        result += gameDTO.getWinningCount()[0] * 5000;
        result += gameDTO.getWinningCount()[1] * 50000;
        result += gameDTO.getWinningCount()[2] * 1500000;
        result += gameDTO.getWinningCount()[3] * 30000000;
        result += gameDTO.getWinningCount()[4] * 2000000000;
        gameDTO.setWinningAmount(result);
    }
}
