package lotto.controller;

import lotto.domain.GameSet;
import lotto.service.LottoService;
import lotto.service.LottoServiceImpl;

import static lotto.view.OutputLotto.printResult;

public class LottoController {
    private LottoService lottoService = new LottoServiceImpl();
    private GameSet gameSet;
    public void run(){
        gameSet = lottoService.startGame();
        lottoService.generateLotto();
        lottoService.generateAwardLotto();
        lottoService.play();
        printResult(gameSet);
    }
}
