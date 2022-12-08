package lotto;

import lotto.controller.LottoController;
import lotto.util.AppConfig;

public class Application {
    public static void main(String[] args) {
        AppConfig appConfig = new AppConfig();
        LottoController lottoController = appConfig.lottoController();
        lottoController.start();
    }
}
