package lottoController;

import common.LottoGameMessage;
import lottoService.LottoService;

public class LottoController {

    private static final LottoService lottoService = new LottoService();

    public void startLottoGame() {
        try {
            lottoService.gameProgress();
        } catch (IllegalArgumentException e) {
            return;
        }


    }
}
