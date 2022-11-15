package lotto;

import lotto.mvc.controller.LottoGameController;
import lotto.mvc.util.LottoGameStatus;

public final class GameRunner {

    private static final LottoGameController CONTROLLER = new LottoGameController();

    private GameRunner() {
    }

    public static void run(LottoGameStatus lottoGameStatus) {
        while (!lottoGameStatus.isExit()) {
            lottoGameStatus = CONTROLLER.process(lottoGameStatus);
        }
    }
}
