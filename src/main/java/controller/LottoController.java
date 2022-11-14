package controller;

import Service.LottoService;

public class LottoController {

    LottoService lottoService = new LottoService();

    public void run(){
        setLotto();
    }

    private void setLotto(){
        lottoService.set_lotto();
    }
}
