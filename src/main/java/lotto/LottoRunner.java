package lotto;

import lotto.controller.LottoController;

public class LottoRunner {
    private LottoController lottoController;

    public void lottoStarter() {
        lottoController = new LottoController();
        try {
            lottoController.runLotto();
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        }

    }

}
