package lotto.Controller;

import lotto.Service.LottoService;
import lotto.Service.LottoServiceImpl;

public class LottoController {
    private final LottoService lottoService;

    public LottoController(){
        this.lottoService = new LottoServiceImpl();
    }

    public void play(){
        lottoService.buyLottos();
        if(lottoService.isPlay()){
            lottoService.generateLottos();
            lottoService.printResult();
        }
    }

}
