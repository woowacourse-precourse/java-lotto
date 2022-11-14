package lotto;

import lotto.global.config.AppConfig;
import lotto.presentation.LottoController;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        final AppConfig appConfig = new AppConfig();
        final LottoController lottoController = appConfig.lottoController();

        try {
            lottoController.run();
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
}
