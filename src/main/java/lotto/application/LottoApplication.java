package lotto.application;

import lotto.application.config.LottoApplicationConfig;

public class LottoApplication {

    private final LottoApplicationContext context;

    public LottoApplication(final LottoApplicationConfig config) {
        this.context = new LottoApplicationContext(config);
    }

    public void run() {
        while (!context.finish()) {
            context.progress();
        }
    }
}
