package controller;

import Service.LottoService;
import Service.WinningService;

public class LottoController {

    LottoService lottoService = new LottoService();
    WinningService winningService = new WinningService();

    public void run(){
        setLotto();
        setWin();
    }

    private void setLotto(){
        lottoService.set_lotto();
    }
    private void setWin() {winningService.set_winning();}
}
