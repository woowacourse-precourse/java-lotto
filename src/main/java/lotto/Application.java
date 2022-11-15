package lotto;

import lotto.controller.LottoSystemController;

public class Application {
    public static void main(String[] args) {
        AppConfig appConfig = new AppConfig();
        LottoSystemController lottoSystemController = appConfig.createLottoSystemController();
        lottoSystemController.run();
    }
}
