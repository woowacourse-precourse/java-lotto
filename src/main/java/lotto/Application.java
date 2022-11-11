package lotto;

import lotto.Controller.LottoGameController;

public class Application {
    public static void main(String[] args) {
        LottoGameController lottoGameController = new LottoGameController();

        lottoGameController.gameStart();
    }
}
