package lotto;

import lotto.controller.LottoGameController;
import lotto.service.LottoGameService;

public class Application {
    public static void main(String[] args) {
        LottoGameController lottoGameController = new LottoGameController(new LottoGameService());
        lottoGameController.run();
    }
}
