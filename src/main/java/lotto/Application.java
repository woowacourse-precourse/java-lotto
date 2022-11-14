package lotto;

import lotto.controller.LottoGameController;
import lotto.service.LottoGame;

public class Application {
    public static void main(String[] args) {
        LottoGame game = new LottoGame();
        LottoGameController controller = new LottoGameController(game);
        controller.startGame();
    }
}
