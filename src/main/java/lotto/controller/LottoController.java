package lotto.controller;

import lotto.service.LottoService;
import lotto.service.LottoServiceImpl;


public class LottoController {
    private LottoService lottoService = new LottoServiceImpl();
    public void run(){
        lottoService.play();
    }
}
