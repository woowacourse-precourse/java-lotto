package lotto;

import config.LottoContainer;
import lotto.presentation.LottoGameController;

public class Application {
    public static void main(String[] args) {
        LottoContainer lottoContainer = LottoContainer.getInstance();
        LottoGameController lottoGameController = lottoContainer.lottoController();

        try {
            lottoGameController.start();
        } catch (IllegalArgumentException e) {
            return;
        }

    }
}
