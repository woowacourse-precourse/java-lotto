package lotto.helper.factory.stub;

import lotto.mvc.controller.LottoGameController;
import lotto.mvc.util.LottoGameStatus;

public class StubLottoGameController extends LottoGameController {

    @Override
    public LottoGameStatus process(LottoGameStatus lottoGameStatus, String playerInput) {
        return lottoGameStatus.findNextGameStatus();
    }
}
