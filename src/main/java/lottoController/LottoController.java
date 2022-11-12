package lottoController;

import common.LottoGameMessage;
import lottoService.LottoService;

public class LottoController {

    LottoService lottoService = new LottoService();

    public void startLottoGame(){
        lottoService.gameProgress();
    }
}
