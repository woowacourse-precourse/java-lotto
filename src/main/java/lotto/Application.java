package lotto;

import lotto.controller.LottoSystemController;

public class Application {

    public static void main(String[] args) {
        LottoSystemConfig lottoSystemConfig = new LottoSystemConfig();
        LottoSystemController lottoSystemController = lottoSystemConfig.lottoSystemController();

        lottoSystemController.runLottoSystem();
    }
}
