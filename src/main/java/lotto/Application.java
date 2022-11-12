package lotto;

import lotto.application.LottoApplication;
import lotto.application.config.LottoApplicationConfig;

public class Application {

    public static void main(String[] args) {
        LottoApplicationConfig config = new LottoApplicationConfig();
        LottoApplication lottoApplication = new LottoApplication(config);
        lottoApplication.run();
    }
}
