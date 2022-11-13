package lotto;

import lottoController.LottoController;

public class Application {
    public static void main(String[] args) {
        LottoController lottoController = new LottoController();
        lottoController.startLottoGame();
    }
}
