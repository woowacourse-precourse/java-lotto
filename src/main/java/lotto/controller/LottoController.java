package lotto.controller;

import lotto.service.LottoService;

public class LottoController {

    private static LottoService lottoService;

    public LottoController(){
        lottoService = new LottoService();
    }


}
