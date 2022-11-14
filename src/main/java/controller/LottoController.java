package controller;

import Service.LottoService;
import Service.WinningService;

public class LottoController {

    LottoService lottoService = new LottoService();

    public void run(){
        lottoService.lottoGame();
    }
}
