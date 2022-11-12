package controller;

import domain.Lotto;
import service.LottoService;

public class LottoController {
    private final LottoService lottoService = new LottoService();

    public Lotto createWinningNumber(String winningNumber) {
        return lottoService.createWinningNumber(winningNumber);
    }
}
