package lotto.controller;

import lotto.model.GameDTO;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class ProcessingGameData {
    private GameDTO gameDTO;

    public ProcessingGameData(GameDTO gameDTO) {
        this.gameDTO = gameDTO;
        makeAllAmount(gameDTO);
        makeRatio(gameDTO);
    }
    private void makeRatio(GameDTO gameDTO) {
        double allAmount = gameDTO.getWinningAmount() * 100;
        double allcost = gameDTO.getPurchaseAmount();

        BigDecimal amount = new BigDecimal(allAmount);
        BigDecimal cost = new BigDecimal(allcost);
        BigDecimal result = amount.divide(cost);
        gameDTO.setReturnOfRate(result.setScale(1, RoundingMode.HALF_UP));
    }

    private void makeAllAmount(GameDTO gameDTO) {
        double result = 0;
        result += gameDTO.getWinningCount()[0] * 5000;
        result += gameDTO.getWinningCount()[1] * 50000;
        result += gameDTO.getWinningCount()[2] * 1500000;
        result += gameDTO.getWinningCount()[3] * 30000000;
        result += gameDTO.getWinningCount()[4] * 2000000000;
        gameDTO.setWinningAmount(result);
    }
}
