package lotto;

import lotto.console.Constants;
import lotto.controller.GameController;
import lotto.controller.LottoController;

public class Application {

    public static void main(String[] args) {
        try {
            LottoController lottoController = new LottoController();
            GameController gameController = new GameController(lottoController);
            gameController.start();
        } catch (IllegalArgumentException e) {
            System.out.println(Constants.ERROR_PREFIX + e.getMessage());
        }
    }


}
